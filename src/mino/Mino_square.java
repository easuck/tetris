package mino;

import java.awt.*;

public class Mino_square extends Mino{

    public Mino_square(){
        color = Color.ORANGE;
        create(color);
    }

    @Override
    public void setCoordinates(int x, int y){
        //## 23
        //## 01
        //
        blocks[0].x = x;
        blocks[0].y = y;
        blocks[1].x = blocks[0].x + Block.size;
        blocks[1].y = blocks[0].y;
        blocks[2].x = blocks[0].x;
        blocks[2].y = blocks[0].y - Block.size;
        blocks[3].x = blocks[0].x + Block.size;
        blocks[3].y = blocks[0].y - Block.size;
    }
}
