package mino;

import java.awt.*;

public class Mino_L extends Mino{

    //private Color c = Color.BLUE;

    public Mino_L(){
        color = Color.BLUE;
        create(color);
    }

    @Override
    public void setCoordinates(int x, int y){
        //.0. 1
        //.0. 0
        //.00 23
        blocks[0].x = x;
        blocks[0].y = y;
        blocks[1].x = blocks[0].x;
        blocks[1].y = blocks[0].y - Block.size;
        blocks[2].x = blocks[0].x;
        blocks[2].y = blocks[0].y + Block.size;
        blocks[3].x = blocks[0].x + Block.size;
        blocks[3].y = blocks[0].y + Block.size;
    }

}
