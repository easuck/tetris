package mino;

import logic.GameManager;

import java.awt.*;

public class Block extends Rectangle {

    private int x2, y2;
    private static final int size = 30;
    private Color c;
    private int autoDropCounter = 0;

    public Block(Color c){
        this.c = c;
        x = 100;
        y = 100;
    }

    public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, size, size);
    }

    public void update(){
        autoDropCounter++;

        if(autoDropCounter == GameManager.autoDropInterval){
            y += 50;
            autoDropCounter = 0;
        }

    }

    public int getX2() {
        return x;
    }

    public int getY2() {
        return y;
    }
}
