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
    ArrayList<String> keys;
    
    public Listener() {
        pressed = new ArrayList();
        released = new ArrayList();
        keys = new ArrayList();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.print("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed.add(System.currentTimeMillis());
        keys.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        released.add(System.currentTimeMillis());
    }
    
    public ArrayList<Long> getPressed() {
        return pressed;
    }
    
    public ArrayList<Long> getReleased() {
        return released;
    }
    
    public void clear() {
        pressed.clear();
        released.clear();
        keys.clear();
    }
    
    public String[] getKeys() {
        String[] temp = new String[keys.size()];
        for(int i = 0; i < keys.size(); i++) {
            temp[i] = keys.get(i);
        }
        return temp;
    }
    
    public String getPhrase() {
        String temp = "";
        for (String key : keys) {
            temp = temp + key;
        }
        return temp;
    }
}