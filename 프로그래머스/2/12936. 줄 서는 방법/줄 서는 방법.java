import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int n, long k) {
        List<Integer> answer = new ArrayList<>();
        long total = factorial(n);
        long group = total / n ;
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 1; i<=n; i++){
            arr.add(i);
        }
        
        k--; // 0-based 인덱스로 맞추기

        for (int i = n; i > 0; i--) {
            total /= i; // (i-1)!
            int index = (int)(k / total);
            answer.add(arr.get(index));
            arr.remove(index);
            k %= total;
        }
        
        return answer;
    }
    
    static public long factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}