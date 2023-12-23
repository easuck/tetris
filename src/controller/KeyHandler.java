package controller;

import mino.Mino;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean downPressed, leftPressed, rightPressed;
    private Mino minoObserver;

    public void addMino(Mino mino){
        this.minoObserver = mino;
    }

    public void notifyObserver(){
        minoObserver
    }

    public void doCommands(){
        while(true){
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
