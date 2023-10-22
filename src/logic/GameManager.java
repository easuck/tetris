package logic;

import gui.GamePanel;
import mino.Block;

import java.util.ArrayList;

public class GameManager implements Runnable{

    private Thread gameThread;
    private GamePanel gamePanel;
    private ArrayList<Block> blocks;
    public final static int fps = 60;
    public final static int autoDropInterval = fps;

    public GameManager(){
        gamePanel = new GamePanel();
        blocks = new ArrayList<>();
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
            if(delta >= 1000){
                gamePanel.update();
                gamePanel.repaint();
                delta--;
            }
        }
    }
}