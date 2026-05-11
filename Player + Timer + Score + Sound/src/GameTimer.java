import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameTimer{
    private int elapsedSeconds;
    private Timer swingTimer;
    private boolean running;

    public GameTimer(ActionListener onTick){
        this.elapsedSeconds = 0;
        this.running = false;
        this.swingTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                elapsedSeconds++;
                if (onTick != null) onTick.actionPerformed(e);
            }
        });
    }

    public String getTimeFormat(){
        int minutes = elapsedSeconds / 60;
        int seconds = elapsedSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public int getElapsedSeconds(){
        return elapsedSeconds;
    }

    public boolean isRunning(){
        return running;
    }

    public void start(){
        if (!running){
            swingTimer.start();
            running = true;
        }
    }

    public void stop(){
        swingTimer.stop();
        running = false;
    }

    public void reset(){
        stop();
        elapsedSeconds = 0;
    }

    public void restart(){
        reset();
        start();
    }
}
