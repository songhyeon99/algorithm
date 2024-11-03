import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<3; i++){
            list.add(new ArrayList<Integer>());
        }
        
        List<Integer> answer = new ArrayList<>();
        
        list.get(0).addAll(Arrays.asList(1,2,3,4,5));
        list.get(1).addAll(Arrays.asList(2,1,2,3,2,4,2,5));
        list.get(2).addAll(Arrays.asList(3,3,1,1,2,2,4,4,5,5));
        int maxCount = 0;
        
        for(int i = 0; i < list.size(); i++){
            int idx = 0;
            int temp = 0;
            while(true){
                for(int j = 0; j < answers.length; j++){
                    if(answers[j] == list.get(i).get(idx)){
                        temp++;
                    }
                    if(idx == list.get(i).size()-1){
                        idx = 0;
                    }else{
                        idx++;
                    }
                }
                break;
            }
            System.out.println("현재 maxCount : " + maxCount + ", "+"temp : " + temp);
            if(maxCount == temp){
                answer.add(i+1);
            }else if(maxCount < temp){
                answer.clear();
                maxCount = temp;
                answer.add(i+1);
            }
       }
        return answer;
    }
}