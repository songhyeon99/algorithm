import java.util.*;
import java.io.*;

class Solution implements Comparator<String>{
    static int order;
    public String[] solution(String[] strings, int n) {
        order = n;
        Arrays.sort(strings, (s1, s2) -> compare(s1, s2));
        return strings;
    }
    
    @Override
    public int compare(String s1, String s2) {
        char c1 = s1.charAt(order);
        char c2 = s2.charAt(order);
        
        String c1ToString = String.valueOf(c1);
        String c2ToString = String.valueOf(c2);
        
        if(c1 == c2) {
            return s1.compareTo(s2);
        }
        return c1ToString.compareTo(c2ToString);
    }
}