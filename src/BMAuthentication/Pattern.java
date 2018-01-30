/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMAuthentication;

import static java.lang.Integer.min;
import java.util.ArrayList;

/**
 *
 * @author Dilantha
 */
public class Pattern {
    private int size;
    private String[] keys;
    private Integer[] dwellTime;
    private Integer[] flightTime;
    private Integer[] upToUpTime;
    
    public Pattern(Listener listener) {
        ArrayList<Long> pressed = listener.getPressed();
        ArrayList<Long> released = listener.getReleased();
        this.keys = listener.getKeys();
        this.size = min(pressed.size(), released.size());
        this.dwellTime = new Integer[size];
        this.flightTime = new Integer[size - 1];
        this.upToUpTime = new Integer[size - 1];
        
        for(int i = 0; i < size; i++) {
            dwellTime[i] = (int) (pressed.get(i) - released.get(i));
        }
        for(int i = 1; i < size; i++) {
            flightTime[i - 1] = (int) (pressed.get(i) - pressed.get(i - 1));
            upToUpTime[i - 1] = (int) (released.get(i) - released.get(i - 1));
        }
        listener.clear();
    }
    
    public Integer[] getDwellTime() {
        return dwellTime;
    }
    
    public Integer[] getFlightTime() {
        return flightTime;
    }
    
    public Integer[] getupToUpTime() {
        return upToUpTime;
    }
    
    public int getSize() {
        return size;
    }
    
    public String[] getKeys() {
        return keys;
    }
    
    public String getPhrase() {
        String temp = "";
        for (String key : keys) {
            if (key.length() == 1) {
                temp = temp + key;
            }
            if(key.equalsIgnoreCase("Space")) {
                temp = temp + " ";
            }
        }
        return temp;
    }
}