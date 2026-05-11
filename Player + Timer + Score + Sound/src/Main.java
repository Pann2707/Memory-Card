public class Main {
    public static void main(String[] args) throws InterruptedException{
        Player player = new Player("An");
        Score score = new Score(player);
        GameTimer timer = new GameTimer(null);
        timer.start();

        System.out.println("=== GAME START ===");

        System.out.println("Match!");
        score.onMatch();
        System.out.println(player);
        Thread.sleep(1000);

        System.out.println("Mismatch!");
        score.onWrong();
        System.out.println(player);
        Thread.sleep(1000);

        System.out.println("Match!");
        score.onMatch();
        System.out.println(player);
        
        timer.stop();
        System.out.println("=== GAME OVER ===");
        System.out.println("Time: " + timer.getTimeFormat());
        score.saveToLeaderboard();
        score.printLearderboard();
    }
}
