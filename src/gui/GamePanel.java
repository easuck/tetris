package gui;

import controller.KeyHandler;
import mino.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    public static final  int windowWidth = 1280;
    public static final int windowHeight = 720;
    public static final int gameWidth = 300;
    public static final int gameHeight = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;
    public int start_x;
    public int start_y;
    Mino currentMino = pickMino();

    public GamePanel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);

        left_x = (windowWidth / 2) - (gameWidth / 2);
        right_x = left_x + gameWidth;
        top_y = (windowHeight / 2) - (gameHeight / 2);
        bottom_y = top_y + gameHeight;

        start_x = left_x + (gameWidth / 2) - Block.size;
        start_y = top_y + Block.size;
        currentMino.setCoordinates(start_x, start_y);
    }

    public Mino pickMino(){
        Mino mino = null;
        int i = new Random().nextInt(7);
        switch(i){
            case 0: mino = new Mino_L(); break;
            case 1: mino = new Mino_L_neg(); break;
            case 2: mino = new Mino_square(); break;
            case 3: mino = new Mino_bar(); break;
            case 4: mino = new Mino_T(); break;
            case 5: mino = new Mino_Z(); break;
            case 6: mino = new Mino_Z_neg(); break;
        }
        return mino;
    }

    public void drawGameField(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4));
        g2.drawRect(left_x - 4,  top_y - 4, gameWidth + 8, gameHeight + 8);
    }

    public void update(){
        currentMino.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGameField(g2);
        if (currentMino != null){
            currentMino.draw(g2);
        }
    }

}
