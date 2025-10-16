import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
         Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        int[] count = new int[number.length];
        
        int days = 0;
        for(int i = 0; i<=discount.length-10; i++){
            for(int j = i; j<i+10; j++){
            if(map.containsKey(discount[j]) &&
               count[map.get(discount[j])] < number[map.get(discount[j])]) {
                count[map.get(discount[j])]++;
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