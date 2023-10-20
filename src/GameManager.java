import java.awt.*;

public class GameManager implements Runnable{

    private Thread gameThread;
    private GamePanel gamePanel;
    private final static int fps = 60;

    public GameManager(){
        gamePanel = new GamePanel();
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000 / fps;
        double delta = 0;
        long lastTime = System.currentTimeMillis();
        long currentTime;
        while(gameThread != null){
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1){
                gamePanel.update();
                gamePanel.repaint();
                delta--;
            }
        }
    }
}
