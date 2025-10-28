class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            schedules[i] = schedules[i] % 100 + 10 >= 60 ? schedules[i] + 50 : schedules[i] + 10;
            System.out.println(schedules[i]);
        }
        
        for(int i = 0; i < timelogs.length; i++) {
            int maxAttendence = schedules[i];
            int tempDay = startday;
            int count = 0;
            for(int j = 0; j<timelogs[0].length; j++) {
                if(tempDay == 6){
                    tempDay++;
                    continue;
                }
                if(tempDay == 7) {
                    tempDay = 1;
                    continue;
                }
                tempDay++;
                if( timelogs[i][j] <= maxAttendence){
                    count++;
                }
                if(count == 5) {
                    answer++;
                }
            }
        }
        return answer;
    }
}