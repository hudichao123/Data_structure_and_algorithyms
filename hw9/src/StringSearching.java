import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of various string searching algorithms.
 *
 * @author Dichao Hu
 * @userid dhu64 (i.e. gburdell3)
 * @GTID Y903253306(i.e. 900000000)
 * @version 1.0
 */
public class StringSearching {

    /**
     * Knuth-Morris-Pratt (KMP) algorithm that relies on the failure table (also
     * called failure function). Works better with small alphabets.
     *
     * Make sure to implement the failure table before implementing this method.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> kmp(CharSequence pattern, CharSequence text,
                                    CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("pattern"
                    + "can not be null or empty");
        }
        if (text == null || comparator == null) {
            throw new IllegalArgumentException("text"
                    + "or comparator can not be null or empty");
        }
        int start = 0;
        int current = 0;
        int patternIndex = 0;
        ArrayList<Integer> a = new ArrayList<>();
        if (pattern.length() > text.length()) {
            return a;
        }
        int[] table = buildFailureTable(pattern, comparator);
        String p = pattern.toString();
        String t = text.toString();
        int failureNum = 0;
        while (start + failureNum + p.length() - patternIndex <= t.length()) {
            int textIndex = start + failureNum;

            int shiftNum;
            while (patternIndex < p.length() && comparator.
                    compare(t.charAt(textIndex), p.charAt(patternIndex)) == 0) {
                textIndex++;
                patternIndex++;
            }
            if (patternIndex == 0) {
                failureNum = 0;
                shiftNum = 1;
                textIndex++;
            } else if (patternIndex >= p.length()) {
                failureNum = table[patternIndex - 1];
                shiftNum = patternIndex  - failureNum;
                a.add(start);
            } else {
                failureNum = table[patternIndex - 1];
                shiftNum = patternIndex - failureNum;
            }
            start += shiftNum;
            patternIndex = failureNum;
        }
        return a;

    }

    /**
     * Builds failure table that will be used to run the Knuth-Morris-Pratt
     * (KMP) algorithm.
     *
     * The table built should be the length of the input text.
     *
     * Note that a given index i will be the largest prefix of the pattern
     * indices [0..i] that is also a suffix of the pattern indices [1..i].
     * This means that index 0 of the returned table will always be equal to 0
     *
     * Ex. ababac
     *
     * table[0] = 0
     * table[1] = 0
     * table[2] = 1
     * table[3] = 2
     * table[4] = 3
     * table[5] = 0
     *
     * If the pattern is empty, return an empty array.
     *
     * @throws IllegalArgumentException if the pattern or comparator is null
     * @param pattern a {@code CharSequence} you're building a failure table for
     * @param comparator the comparator to use when checking character equality
     * @return integer array holding your failure table
     */
    public static int[] buildFailureTable(CharSequence pattern,
                                          CharacterComparator comparator) {
        if (pattern == null || comparator == null) {
            throw new IllegalArgumentException("pattern"
                    + "or comparator can not be null");
        }
        int[] table = new int[pattern.length()];
        if (pattern.length() == 0) {
            return table;
        }

        String p = pattern.toString();
        int i = 0;
        int j = 0;
        table[j] = 0;
        j++;
        while (j < p.length()) {
            char c1 = p.charAt(i);
            char c2 = p.charAt(j);
            if (comparator.compare(c1, c2) == 0) {
                table[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = table[i - 1];
                } else {
                    table[j] = 0;
                    j++;
                }
            }

        }
        return table;
    }

    /**
     * Boyer Moore algorithm that relies on last occurrence table. Works better
     * with large alphabets.
     *
     * Make sure to implement the last occurrence table before implementing this
     * method.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for the pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> boyerMoore(CharSequence pattern,
                       CharSequence text, CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("pattern"
                    + "can not be null or empty");
        }
        if (text == null || comparator == null) {
            throw new IllegalArgumentException("text"
                    + "or comparator can not be null or empty");
        }
        List<Integer> l = new ArrayList<>();
        String t = text.toString();
        String p = pattern.toString();
        int patternIndex = p.length() - 1;
        int textIndex = patternIndex;
        Map<Character, Integer> m = buildLastTable(pattern);
        while (textIndex < t.length()) {
            while (patternIndex >= 0 && comparator.compare(t.charAt(textIndex),
                    p.charAt(patternIndex)) == 0) {
                textIndex--;
                patternIndex--;
            }
            if (patternIndex < 0) {
                l.add(textIndex + 1);
                textIndex += p.length() + 1;
                patternIndex = p.length() - 1;
            } else {
                char charInText = t.charAt(textIndex);
                char charInPattern = p.charAt(patternIndex);
                int lastIndex;
                if (m.get(charInText) != null) {
                    lastIndex = m.get(charInText);
                } else {
                    lastIndex = -1;
                }
                int shift = patternIndex - lastIndex;
                if (shift <= 0) {
                    shift = 1;
                }
                textIndex += shift + pattern.length() - 1 - patternIndex;
                patternIndex = pattern.length() - 1;
            }
        }
        return l;
    }

    /**
     * Builds last occurrence table that will be used to run the Boyer Moore
     * algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     *
     * @throws IllegalArgumentException if the pattern is null
     * @param pattern a {@code CharSequence} you are building last table for
     * @return a Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern can not be null");
        }
        Map<Character, Integer> m = new HashMap<>();
        String s = pattern.toString();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, i);
        }
        return m;
    }

    /**
     * Prime base used for Rabin-Karp hashing.
     * DO NOT EDIT!
     */
    private static final int BASE = 181;

    /**
     * Runs Rabin-Karp algorithm. Generate the pattern hash, and compare it with
     * the hash from a substring of text that's the same length as the pattern.
     * If the two hashes match, compare their individual characters, else update
     * the text hash and continue.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern a string you're searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> rabinKarp(CharSequence pattern,
                      CharSequence text, CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("pattern"
                    + "can not be null or empty");
        }
        if (text == null || comparator == null) {
            throw new IllegalArgumentException("text"
                    + "or comparator can not be null or empty");
        }
        int patternHash = generateHash(pattern, pattern.length());
        int textHash = generateHash(text, pattern.length());
        List<Integer> l = new ArrayList<>();
        String p = pattern.toString();
        String t = text.toString();
        for (int i = 0; i <=  t.length() - p.length(); i++) {
            if (patternHash == textHash) {
                boolean match = true;
                for (int j = 0; j < p.length() && match; j++) {
                    if (comparator.compare(p.charAt(j), t.charAt(i + j)) != 0) {
                        match = false;
                    }
                }
                if (match) {
                    l.add(i);
                }
            }
            if (i != t.length() - p.length()) {
                textHash = updateHash(textHash, pattern.length(), t.charAt(i),
                        t.charAt(i + p.length()));
            }
        }
        return l;
    }

    /**
     * Hash function used for Rabin-Karp. The formula for hashing a string is:
     *
     * sum of: c * BASE ^ (pattern.length - 1 - i), where c is the integer
     * value of the current character, and i is the index of the character
     *
     * For example: Hashing "bunn" as a substring of "bunny" with base 181 hash
     * = b * 181 ^ 3 + u * 181 ^ 2 + n * 181 ^ 1 + n * 181 ^ 0 = 98 * 181 ^ 3 +
     * 117 * 181 ^ 2 + 110 * 181 ^ 1 + 110 * 181 ^ 0 = 584967675
     *
     * Note that the largest possible value for an int is 2147483647, so it is
     * possible that the calculated hash may roll over.
     *
     *
     * Do NOT use {@code Math.pow()} in this method. We have provided a pow()
     * method for you to use.
     *
     * @throws IllegalArgumentException if current is null
     * @throws IllegalArgumentException if length is negative, 0, or greater
     *     than the length of current
     * @param current substring you are generating hash function for
     * @param length the length of the string you want to generate the hash for,
     * starting from index 0. For example, if length is 4 but current's length
     * is 6, then you include indices 0-3 in your hash (and pretend the actual
     * length is 4)
     * @return hash of the substring
     */
    public static int generateHash(CharSequence current, int length) {
        if (current == null) {
            throw new IllegalArgumentException("charSequence can not be null");
        }
        if (length <= 0 || length > current.length()) {
            throw new IllegalArgumentException("length should be in the range");
        }
        int sum = 0;
        String s = current.toString();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int num = pow(BASE, length - 1 - i);
            sum += num * c;
        }
        return sum;
    }

    /**
     * Updates a hash in constant time to avoid constantly recalculating
     * entire hash. To update the hash:
     *
     *  remove the oldChar times BASE raised to the length - 1, multiply by
     *  BASE, and add the newChar.
     *
     * For example: Shifting from "bunn" to "unny" in "bunny" with base 181
     * hash("unny") = (hash("bunn") - b * 181 ^ 3) * 181 + y * 181 ^ 0 =
     * (584967675 - 98 * 181 ^ 3) * 181 + 121 * 181 ^ 0 = 697403438
     *
     *
     * The computation of BASE raised to length - 1 may require O(log n) time,
     * but the method should otherwise run in O(1).
     *
     * Do NOT use {@code Math.pow()} in this method. We have provided a pow()
     * method for you to use.
     *
     * @throws IllegalArgumentException if length is negative or 0
     * @param oldHash hash generated by generateHash
     * @param length length of pattern/substring of text
     * @param oldChar character we want to remove from hashed substring
     * @param newChar character we want to add to hashed substring
     * @return updated hash of this substring
     */
    public static int updateHash(int oldHash, int length, char oldChar,
                                 char newChar) {

        return BASE * (oldHash - oldChar * pow(BASE, length - 1)) + newChar;
    }

    /**
     * Calculate the result of a number raised to a power.
     *
     * DO NOT MODIFY THIS METHOD.
     *
     * @throws IllegalArgumentException if both {@code base} and {@code exp} are
     * 0
     * @throws IllegalArgumentException if {@code exp} is negative
     * @param base base of the number
     * @param exp power to raise the base to. Must be 0 or greater.
     * @return result of the base raised to that power
     */
    private static int pow(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative.");
        } else if (base == 0 && exp == 0) {
            throw new IllegalArgumentException(
                    "Both base and exponent cannot be 0.");
        } else if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        }
        int halfPow = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * pow(base, (exp / 2) + 1);
        }
    }
}
