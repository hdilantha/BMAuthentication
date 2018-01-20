/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMAuthentication;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Dilantha
 */
public class Listener implements KeyListener{
    ArrayList<Long> pressed;
    ArrayList<Long> released;
    ArrayList<String> pressedKeys;
    ArrayList<String> releasedKeys;
    
    public Listener() {
        pressed = new ArrayList();
        released = new ArrayList();
        pressedKeys = new ArrayList();
        releasedKeys = new ArrayList();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.print("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed.add(System.currentTimeMillis());
        pressedKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        released.add(System.currentTimeMillis());
        releasedKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
    }
    
    public void showInfo() {
        int temp;
        for(int i = 1; i < pressed.size(); i++) {
            temp = (int) (pressed.get(i) - pressed.get(i - 1));
            System.out.print(temp + " ");
        }
        System.out.print("   ");
        for(int i = 0; i < released.size(); i++) {
            temp = (int) (released.get(i) - pressed.get(i));
            System.out.print(temp + " ");
        }
        System.out.print("   ");
        for(int i = 0; i < pressedKeys.size(); i++) {
            System.out.print(pressedKeys.get(i) + " ");
        }
        System.out.println("");
    }
    
    public Integer[] getPressed() {
        Integer[] temp = new Integer[pressed.size() - 1];
        for(int i = 1; i < pressed.size(); i++) {
            temp[i - 1] = (int) (pressed.get(i) - pressed.get(i - 1));
        }
        return temp;
    }
    
    public String getPressedKeys() {
        String temp = "";
        for(int i = 0; i < pressedKeys.size() - 1; i++) {
            temp = temp + pressedKeys.get(i) + " ";
        }
        temp = temp + pressedKeys.get(pressedKeys.size() - 1);
        return temp;
    }
    
    public Integer[] getReleased() {
        Integer[] temp = new Integer[released.size() - 1];
        for(int i = 1; i < released.size(); i++) {
            temp[i - 1] = (int) (released.get(i) - released.get(i - 1));
        }
        return temp;
    }
    
    public String[] getReleasedKeys() {
        String[] temp = new String[releasedKeys.size()];
        for(int i = 0; i < releasedKeys.size(); i++) {
            temp[i] = releasedKeys.get(i);
        }
        return temp;
    }
    
    public Integer[] getDifference() {
        Integer[] temp = new Integer[pressed.size()];
        for(int i = 0; i < pressed.size(); i++) {
            temp[i] = (int) (pressed.get(i) - released.get(i));
        }
        return temp;
    }
    public void clear() {
        pressed.clear();
        released.clear();
        pressedKeys.clear();
        releasedKeys.clear();
    }
}
