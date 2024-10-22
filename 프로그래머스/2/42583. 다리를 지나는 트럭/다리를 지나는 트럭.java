import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time=0;
        int sum=0;

        for(int i = 0; i<bridge_length; i++){
            queue.add(0);
        }
        
        int index = 0;
        while(index < truck_weights.length){
            sum -= queue.poll();
            time++;
            
            if(sum + truck_weights[index] <= weight){
                int curTruck = truck_weights[index];
                queue.add(truck_weights[index]);
                sum += truck_weights[index];
                index++;
            }else{
                queue.add(0);
            }
        }
        return time + bridge_length;
    }
}