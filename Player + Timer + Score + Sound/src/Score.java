import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Score {
    public static final int BONUS = 10;
    public static final int PENALTY = 5;
    private Player player;
    private List<Player> leaderboard;
    public Score(Player player){
        this.player = player;
        this.leaderboard = new ArrayList<>();
    }

    public Player getPlayer(){
        return player;
    }

    public void onMatch(){
        player.addScore(BONUS);
        player.incrementMoves();
    }

    public void onWrong(){
        player.deductScore(PENALTY);
        player.incrementMoves();
    }

    public void saveToLeaderboard(){
        Player resultshot = new Player(player.getName());
        resultshot.addScore(player.getScore());
        leaderboard.add(resultshot);
        leaderboard.sort(Comparator.comparingInt(Player::getScore).reversed());
    }

    public List<Player> getTopPlayers(int n){
        return leaderboard.subList(0, Math.min(n, leaderboard.size()));
    }

    public void printLearderboard(){
        System.out.print("===  LEARDERBOARD ===\n");
        List<Player> top = getTopPlayers(5);
        for (int i =0; i < top.size(); i++){
            System.out.println((i + 1) + "." + top.get(i));
        }
    }
}
