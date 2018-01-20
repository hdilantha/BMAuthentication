/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMAuthentication;

import java.util.ArrayList;

/**
 *
 * @author Dilantha
 */
public class Analyzer {
    
    public Integer analyze(Integer[] tempPres, Integer[] tempDif, ArrayList<Integer[]> storePress, ArrayList<Integer[]> storeDiff) {
        int max = 0;
        int maxp = 0;
        for (int j = 0; j < storePress.size(); j++) {
            int t1 = check(tempPres, storePress.get(j), 50);
            int t2 = check(tempDif, storeDiff.get(j), 50);
            int t = t1 + t2;
            System.out.println(Integer.toString(t));
            if (t > max) {
                max = t;
                maxp = j + 1;
            }
        }
        return maxp;
    }
    
    private Integer check(Integer[] arr1, Integer[] arr2, int error) {
        int marks = 0;
        for(int i = 0; i < arr1.length; i++) {
            if ((arr1[i] - arr2[i] < error) && (arr1[i] - arr2[i] > -error)) {
                marks++;
            }
        }
        return marks;
    }
}
