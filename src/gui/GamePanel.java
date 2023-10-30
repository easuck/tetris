package gui;

import mino.Block;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public static final  int windowWidth = 1280;
    public static final int windowHeight = 720;
    public static final int gameWidth = 300;
    public static final int gameHeight = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    Block testBlock = new Block(Color.BLUE);

    public GamePanel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);

        left_x = (windowWidth / 2) - (gameWidth / 2);
        right_x = left_x + gameWidth;
        top_y = (windowHeight / 2) - (gameHeight / 2);
        bottom_y = top_y + gameHeight;
    }

    public void drawGameField(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4));
        g2.drawRect(left_x - 4,  top_y - 4, gameWidth + 8, gameHeight + 8);
    }

    public void update(){
        testBlock.update();
        System.out.println("координаты " + testBlock.getX2() + " и " + testBlock.getY2());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGameField(g2);
        testBlock.draw(g2);
        //System.out.println("я отрисовал блок с координатами " + testBlock.getX2() + " и " + testBlock.getY2());
    }

}
