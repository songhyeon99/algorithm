class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        answer = check(s);
        return answer;
    }
    
    static public boolean check(String s) {
        if(s.length() == 4 || s.length() == 6) {
            return checkNumber(s);
        }
        return false;
    }
    
    static public boolean checkNumber(String s) {
        for(int i = 0; i<s.length(); i++) {
            int num = Integer.valueOf(s.charAt(i) - '0');
            if(num < 0 || num > 9) return false;
        }
        return true;
    }
}