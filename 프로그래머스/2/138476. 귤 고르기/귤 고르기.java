import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Integer[] mandarin = new Integer[10000001];
        Arrays.fill(mandarin, 0);
        for(int i = 0; i<tangerine.length; i++){
            mandarin[tangerine[i]]++;
        }
        Arrays.sort(mandarin, Collections.reverseOrder());
        
        int count = 0;
        int result = 0;
        for(int i =0; i<tangerine.length; i++){
            if(k <= mandarin[i]){
                return 1;
            }else{
                if(count + mandarin[i] < k){
                    count += mandarin[i];
                    result++;
                }else{
                    result++;
                    return result;
                }
            }
        }
        return result;
    }
}