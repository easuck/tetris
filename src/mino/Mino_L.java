package mino;

import java.awt.*;

public class Mino_L extends Mino{

    public Mino_L(){
        color = Color.BLUE;
        create(color);
    }

    @Override
    public void setCoordinates(int x, int y){
        //# 1
        //# 0
        //## 23
        blocks[0].x = x;
        blocks[0].y = y;
        blocks[1].x = blocks[0].x;
        blocks[1].y = blocks[0].y - Block.size;
        blocks[2].x = blocks[0].x;
        blocks[2].y = blocks[0].y + Block.size;
        blocks[3].x = blocks[0].x + Block.size;
        blocks[3].y = blocks[0].y + Block.size;
    }

    @Override
    public void getDirection1(){
        //#
        //#
        //##
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x;
        tempBlocks[1].y = blocks[0].y - Block.size;
        tempBlocks[2].x = blocks[0].x;
        tempBlocks[2].y = blocks[0].y + Block.size;
        tempBlocks[3].x = blocks[0].x + Block.size;
        tempBlocks[3].y = blocks[0].y + Block.size;

        updateDirection(1);
    }

    @Override
    public void getDirection2(){
        //
        //### 201
        //# 3
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x + Block.size;
        tempBlocks[1].y = blocks[0].y;
        tempBlocks[2].x = blocks[0].x - Block.size;
        tempBlocks[2].y = blocks[0].y;
        tempBlocks[3].x = blocks[0].x - Block.size;
        tempBlocks[3].y = blocks[0].y + Block.size;

        updateDirection(2);
    }

    @Override
    public void getDirection3(){
        //## 32
        //.# 0
        //.# 1
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x;
        tempBlocks[1].y = blocks[0].y + Block.size;
        tempBlocks[2].x = blocks[0].x;
        tempBlocks[2].y = blocks[0].y - Block.size;
        tempBlocks[3].x = blocks[0].x - Block.size;
        tempBlocks[3].y = blocks[0].y - Block.size;

        updateDirection(3);
    }

    @Override
    public void getDirection4(){
        //..# 3
        //### 102
        //
        tempBlocks[0].x = blocks[0].x;
        tempBlocks[0].y = blocks[0].y;
        tempBlocks[1].x = blocks[0].x - Block.size;
        tempBlocks[1].y = blocks[0].y;
        tempBlocks[2].x = blocks[0].x + Block.size;
        tempBlocks[2].y = blocks[0].y;
        tempBlocks[3].x = blocks[0].x + Block.size;
        tempBlocks[3].y = blocks[0].y - Block.size;

        updateDirection(4);
    }
}
