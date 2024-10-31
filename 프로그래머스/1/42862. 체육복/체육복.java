import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) {
            lostList.add(l);
        }
        for (int r : reserve) {
            reserveList.add(r);
        }
        
        List<Integer> intersection = new ArrayList<>(lostList);
        intersection.retainAll(reserveList);
        
        lostList.removeAll(intersection);
        reserveList.removeAll(intersection);
        
        boolean[] isLost = new boolean[n+2];
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        for(int i = 0; i < lostList.size(); i++){
            isLost[lostList.get(i)] = true;
        }
        
        
        for(int i = 0; i<reserveList.size(); i++){
            if(isLost[reserveList.get(i)]){
                isLost[reserveList.get(i)] = false;
            }else if(isLost[reserveList.get(i)-1]){
                isLost[reserveList.get(i)-1] = false;
            }else if(isLost[reserveList.get(i)+1]){
                isLost[reserveList.get(i)+1] = false;
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(!isLost[i]) count++;
        }
        return count;
    }
}