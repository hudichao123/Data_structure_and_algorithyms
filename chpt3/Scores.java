public class Scores {
    public static final int maxEntries = 10;
    protected int numEntries;
    protected GameEntry[] entries;
    
    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }
    
    public String toString() {
        String s = "[";
        for (int i = 0; i < entries.length; i++) {
            if (i > 0) {
                s += " ,";
            }
            s += entries[i];
        }
        s += "]";
        return s;
    }
    
    public void add(GameEntry g) {
        String s = g.getName();
        int newScore = g.getScore();
        if (numEntries == maxEntries) {
            if (entries[numEntries - 1].getScore() < newScore) {
               for (int i1 = numEntries - 1; i1 >=0; i1++) {
                   if ()
               }
            }
        } else {
        
        }
    }
    
    public static void main(String[] args) {
        GameEntry g1 = new GameEntry("A", 1);
        GameEntry g2 = new GameEntry("B", 2);
        Scores s = new Scores();
        
    }
    
    
}