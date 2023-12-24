package mino;

import controller.KeyHandler;
import gui.GamePanel;
import logic.GameManager;

import java.awt.*;

public class Mino {

    public Block[] blocks = new Block[4];
    protected Block[] tempBlocks = new Block[4];
    protected Color color;
    protected int autoDropCounter = 0;
    protected int direction = 1;
    protected boolean leftCollision, rightCollision, bottomCollision;
    public boolean isActive = true;

    public void create(Color c){
        blocks[0] = new Block(c);
        blocks[1] = new Block(c);
        blocks[2] = new Block(c);
        blocks[3] = new Block(c);
        tempBlocks[0] = new Block(c);
        tempBlocks[1] = new Block(c);
        tempBlocks[2] = new Block(c);
        tempBlocks[3] = new Block(c);
    }

    public void getDirection1(){};
    public void getDirection2(){};
    public void getDirection3(){};
    public void getDirection4(){};

    public void updateDirection(int direction){
        checkRotationCollision();
        if (!leftCollision && !rightCollision && !bottomCollision){
            this.direction = direction;
            blocks[0].x = tempBlocks[0].x;
            blocks[0].y = tempBlocks[0].y;
            blocks[1].x = tempBlocks[1].x;
            blocks[1].y = tempBlocks[1].y;
            blocks[2].x = tempBlocks[2].x;
            blocks[2].y = tempBlocks[2].y;
            blocks[3].x = tempBlocks[3].x;
            blocks[3].y = tempBlocks[3].y;
        }
    }

    public void checkRotationCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkStaticBlocksCollision();

        for(int i = 0; i < blocks.length; i++){
            if(tempBlocks[i].x < GamePanel.left_x){
                leftCollision = true;
            }
        }

        for(int i = 0; i < blocks.length; i++){
            if(tempBlocks[i].x + Block.size > GamePanel.right_x){
                rightCollision = true;
            }
        }

        for(int i = 0; i < blocks.length; i++){
            if(tempBlocks[i].y + Block.size > GamePanel.bottom_y){
                bottomCollision = true;
            }
        }
    }

    public void checkMovementCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkStaticBlocksCollision();

        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].x == GamePanel.left_x){
                leftCollision = true;
            }
        }

        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].x + Block.size == GamePanel.right_x){
                rightCollision = true;
            }
        }

        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].y + Block.size == GamePanel.bottom_y){
                bottomCollision = true;
            }
        }
    }

    public void checkStaticBlocksCollision(){
        for(int i = 0; i < GamePanel.staticBlocks.size(); i++){
            int targetX = GamePanel.staticBlocks.get(i).x;
            int targetY = GamePanel.staticBlocks.get(i).y;

            for(int j = 0; j < blocks.length; j++){
                if(blocks[j].x == targetX && blocks[j].y + Block.size == targetY){
                    bottomCollision = true;
                }
            }

            for(int j = 0; j < blocks.length; j++){
                if(blocks[j].x == targetX - Block.size && blocks[j].y == targetY){
                    leftCollision = true;
                }
            }

            for(int j = 0; j < blocks.length; j++){
                if(blocks[j].x + Block.size == targetX && blocks[j].y == targetY){
                    rightCollision = true;
                }
            }
        }
    }

    public void setCoordinates(int x, int y){};

    public void update(){
        if(KeyHandler.upPressed){
            switch(direction){
                case 1: getDirection2(); break;
                case 2: getDirection3(); break;
                case 3: getDirection4(); break;
                case 4: getDirection1(); break;
            }
            KeyHandler.upPressed = false;
        }

        checkMovementCollision();

        if(KeyHandler.downPressed){
            if(!bottomCollision){
                blocks[0].y += Block.size;
                blocks[1].y += Block.size;
                blocks[2].y += Block.size;
                blocks[3].y += Block.size;
                autoDropCounter = 0;
            }
            KeyHandler.downPressed = false;
        }
        if(KeyHandler.leftPressed){
            if(!leftCollision){
                blocks[0].x -= Block.size;
                blocks[1].x -= Block.size;
                blocks[2].x -= Block.size;
                blocks[3].x -= Block.size;
            }
            KeyHandler.leftPressed = false;
        }
        if(KeyHandler.rightPressed){
            if(!rightCollision){
                blocks[0].x += Block.size;
                blocks[1].x += Block.size;
                blocks[2].x += Block.size;
                blocks[3].x += Block.size;
            }
            KeyHandler.rightPressed = false;
        }
        if (bottomCollision){
            isActive = false;
        }
        else{
            autoDrop();
        }
    }

    public void autoDrop(){
        autoDropCounter++;
        if(autoDropCounter == GameManager.autoDropInterval){
            for (int i = 0; i < blocks.length; i++){
                blocks[i].y += 30;
            }
            autoDropCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
        int padding = 2;
        g2.setColor(color);
        g2.fillRect(blocks[0].x + padding, blocks[0].y + padding, Block.size - (padding * 2), Block.size - (padding * 2));
        g2.fillRect(blocks[1].x + padding, blocks[1].y + padding, Block.size - (padding * 2), Block.size - (padding * 2));
        g2.fillRect(blocks[2].x + padding, blocks[2].y + padding, Block.size - (padding * 2), Block.size - (padding * 2));
        g2.fillRect(blocks[3].x + padding, blocks[3].y + padding, Block.size - (padding * 2), Block.size - (padding * 2));
    };

}
