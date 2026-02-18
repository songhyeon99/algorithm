import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
			String answer = "";
			String[] sArray;
			sArray = s.split(" ");
			int length = sArray.length;
			int[] n = new int[length];
			for(int i = 0; i <length; i++){
				n[i] = Integer.valueOf(sArray[i]);
			}

			Arrays.sort(n);

			answer = n[0] + " " + n[length-1];
			return answer;
    }
}