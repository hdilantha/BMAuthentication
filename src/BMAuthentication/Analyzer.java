/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMAuthentication;

/**
 *
 * @author Dilantha
 */
public class Analyzer {
    
    public boolean analyze(Pattern patternCheck, Pattern patternStore, int percentage) {
        int dwellTimeCheck = check(patternCheck.getDwellTime(), patternStore.getDwellTime(), 30);
        int flightTimeCheck = check(patternCheck.getFlightTime(), patternStore.getFlightTime(), 50);
        int upToUpTimeCheck = check(patternCheck.getupToUpTime(), patternStore.getupToUpTime(), 50);
        int total = dwellTimeCheck + flightTimeCheck + upToUpTimeCheck;
        return total > (patternStore.getSize() * percentage * 0.03);
    }
    
    private Integer check(Integer[] arr1, Integer[] arr2, int error) {
        int marks = 0;
        for(int i = 0; i < arr2.length; i++) {
            if ((arr1[i] - arr2[i] < error) && (arr1[i] - arr2[i] > -error)) {
                marks++;
            }
        }
        return marks;
    }
}
