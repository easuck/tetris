package mino;

import logic.GameManager;

import java.awt.*;

public class Mino {

    protected Block[] blocks = new Block[4];
    protected Color color;
    private int autoDropCounter = 0;

    public void create(Color c){
        blocks[0] = new Block(c);
        blocks[1] = new Block(c);
        blocks[2] = new Block(c);
        blocks[3] = new Block(c);
    }

    public void setCoordinates(int x, int y){};

    public void update(){
        autoDrop();
    }

    public void autoDrop(){
        autoDropCounter++;
        if(autoDropCounter == GameManager.autoDropInterval){
            for (int i = 0; i < blocks.length; i++){
                blocks[i].y += 30;
            }
            autoDropCounter = 0;
            System.out.println("координата У верхнего блока: " + blocks[1].y);
        }
    }

    public void draw(Graphics2D g2){
        int margin = 2;
        g2.setColor(color);
        g2.fillRect(blocks[0].x + margin, blocks[0].y + margin, Block.size - (margin * 2), Block.size - (margin * 2));
        g2.fillRect(blocks[1].x + margin, blocks[1].y + margin, Block.size - (margin * 2), Block.size - (margin * 2));
        g2.fillRect(blocks[2].x + margin, blocks[2].y + margin, Block.size - (margin * 2), Block.size - (margin * 2));
        g2.fillRect(blocks[3].x + margin, blocks[3].y + margin, Block.size - (margin * 2), Block.size - (margin * 2));
    };

}
