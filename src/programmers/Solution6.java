package programmers;

import java.util.*;
class Solution6 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time=0;
        int sum=0;

        for(int i=0; i<truck_weights.length;i++){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck_weights[i]);
                    time++;
                    sum+= truck_weights[i];
                    break;
                }else{
                    if(bridge_length==queue.size()){
                        sum -= queue.poll();
                    }else if((sum+truck_weights[i])<=weight){
                        queue.add(truck_weights[i]);
                        sum+= truck_weights[i];
                        time++;
                        break;
                    }else if((sum+truck_weights[i])>weight){
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}