import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max=0 ,count=0;
        List<Integer> list = new ArrayList<>();
        int[] remainProgresses = new int [progresses.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length;i++){
            remainProgresses[i]=100-progresses[i];
            if(remainProgresses[i]%speeds[i]!=0) queue.add((remainProgresses[i]/speeds[i])+1);
               else queue.add(remainProgresses[i]/speeds[i]);
                 
        }
        
      
        while(!queue.isEmpty()){
         int progress = queue.poll();
         if(max<progress){
             max=progress;
             list.add(count+1);
         }else{
             list.set(list.size()-1,list.get(list.size()-1) + 1);
         }
        }
        
        int [] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
          
        }
    }
