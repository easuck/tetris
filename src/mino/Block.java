package mino;

import logic.GameManager;

import java.awt.*;

public class Block extends Rectangle {

    public static final int size = 30;
    private Color c;

    public Block(Color c){
        this.c = c;
        x = 100;
        y = 100;
    }

    /*public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, size, size);
    }*/

}
