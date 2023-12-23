package mino;

import java.awt.*;

public class Mino_T extends Mino{

    public Mino_T(){
        color = Color.PINK;
        create(color);
    }

    @Override
    public void setCoordinates(int x, int y){
        //.# 1
        //### 203
        //
        blocks[0].x = x;
        blocks[0].y = y;
        blocks[1].x = blocks[0].x;
        blocks[1].y = blocks[0].y - Block.size;
        blocks[2].x = blocks[0].x - Block.size;
        blocks[2].y = blocks[0].y;
        blocks[3].x = blocks[0].x + Block.size;
        blocks[3].y = blocks[0].y;
    }

    @Override
    public void getDirection1(){
        //.# 1
        //### 203
        //
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x;
        tempBlocks[1].y = blocks[0].y - Block.size;
        tempBlocks[2].x = blocks[0].x - Block.size;
        tempBlocks[2].y = blocks[0].y;
        tempBlocks[3].x = blocks[0].x + Block.size;
        tempBlocks[3].y = blocks[0].y;

        updateDirection(1);
    }

    @Override
    public void getDirection2(){
        //# 2
        //## 01
        //# 3
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x + Block.size;
        tempBlocks[1].y = blocks[0].y;
        tempBlocks[2].x = blocks[0].x;
        tempBlocks[2].y = blocks[0].y - Block.size;
        tempBlocks[3].x = blocks[0].x;
        tempBlocks[3].y = blocks[0].y + Block.size;

        updateDirection(2);
    }

    @Override
    public void getDirection3(){
        //
        //### 302
        //.# 1
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x;
        tempBlocks[1].y = blocks[0].y + Block.size;
        tempBlocks[2].x = blocks[0].x + Block.size;
        tempBlocks[2].y = blocks[0].y;
        tempBlocks[3].x = blocks[0].x - Block.size;
        tempBlocks[3].y = blocks[0].y;

        updateDirection(3);
    }

    @Override
    public void getDirection4(){
        //.# 3
        //## 10
        //.# 2
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x - Block.size;
        tempBlocks[1].y = blocks[0].y;
        tempBlocks[2].x = blocks[0].x;
        tempBlocks[2].y = blocks[0].y + Block.size;
        tempBlocks[3].x = blocks[0].x;
        tempBlocks[3].y = blocks[0].y - Block.size;

        updateDirection(4);
    }
}
