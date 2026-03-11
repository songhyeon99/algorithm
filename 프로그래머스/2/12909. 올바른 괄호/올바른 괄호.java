import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();
        
        if(s.charAt(0) == '(') {
            stack.add('(');
        }else{
            return false;
        }
        
        for(int i = 1; i< s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.add('(');
            }else{
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    if(c == ')') return false;
                }
            }
        }
        if(stack.size() > 0) return false;

        return answer;
    }
}