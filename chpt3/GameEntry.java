public class GameEntry {
    protected String name;
    protected int score;
    
    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
        
    
    }
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public String toString() {
        return "(" + name + "," + score + ")";
    }
}