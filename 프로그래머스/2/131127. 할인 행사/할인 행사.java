import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Set<String> wantSet = new HashSet<>(Arrays.asList(want));
        List<String> wantList = Arrays.asList(want);
        int[] count = new int[number.length];
        
        int days = 0;
        for(int i = 0; i<=discount.length-10; i++){
            for(int j = i; j<i+10; j++){
            if(wantSet.contains(discount[j]) &&
               count[wantList.indexOf(discount[j])] < number[wantList.indexOf(discount[j])]) {
                count[wantList.indexOf(discount[j])]++;
                days++;
            }else{
                count = new int[number.length];
                days = 0;
                break;
            }
        }
            if(days >= 10) {
                count = new int[number.length];
                days = 0;
                answer++;
            }
        }
        return answer;
    }
}