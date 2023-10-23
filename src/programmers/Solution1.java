package programmers;

import java.util.*;

public class Solution1 {
    public int[] solution(int []arr) {
        List<Integer> numbers = new ArrayList<>();
        int num=-1;
        for(int i=0;i<arr.length;i++){
            if(num!=arr[i]) {
                num=arr[i];
                numbers.add(num);
            };
        }

        int[] answer = new int[numbers.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=numbers.get(i);
        }

        return answer;
    }
}

/*
 https://velog.io/@shyeon4643/Programmers-%EA%B0%99%EC%9D%80-%EC%88%AB%EC%9E%90%EB%8A%94-%EC%8B%AB%EC%96%B4
 * */