import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int size = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i<size; i++){
           char max = 0;
            for(int j = index; j <= i+k; j++){
                if(max < number.charAt(j)) {
					max = number.charAt(j);
					index = j + 1;
				}
            }
            sb.append(max);
        }
    return sb.toString();
    }
}