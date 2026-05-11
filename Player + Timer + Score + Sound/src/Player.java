public class Player{
    private String name;
    private int score;
    private int moves;
    public Player(String name){
        this.name = name;
        this.score = 0;
        this.moves = 0;
    }

    public void addScore(int points){
        this.score += points;
    }

    public void deductScore(int points){
        this.score = Math.max(0, this.score - points);
    }

    public void incrementMoves(){
        this.moves++;
    }

    public void reset(){
        this.score = 0;
        this.moves = 0;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int getMoves(){
        return moves;
    }

    @Override
    public String toString(){
        return name + " | Score: " + score + " | Moves: " + moves;
    }
}
