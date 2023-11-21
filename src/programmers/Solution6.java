package programmers;

import java.util.*;

class Solution6 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();


        for(int i =0; i<commands.length;i++){
            List<Integer> list = new ArrayList<>();
            int len = commands[i][1] - commands[i][0]+1;
            int start =commands[i][0]-1;
            for(int j = commands[i][0]-1; j<commands[i][1];j++){
                list.add(array[j]);
            }

            for(int k=1 ; k<list.size();k++){
                int key = list.get(k), l = k-1;
                while(l>=0 && key < list.get(l)){
                    list.set(l + 1, list.get(l));
                    l--;
                }
                list.set(l+1,key);
            }
            answerList.add(list.get(commands[i][2]-1));
        }
        int[] answerArray = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answerArray;
    }
}