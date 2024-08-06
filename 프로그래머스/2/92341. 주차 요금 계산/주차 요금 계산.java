import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        boolean[] visited = new boolean[records.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        String[][] arr = new String[records.length][3];

        for (int i = 0; i < records.length; i++) {
            arr[i] = records[i].split(" ");
        }

        for (int i = 0; i < records.length; i++) {
            if (!visited[i]) {
                boolean isDone = false;
                visited[i] = true;
                String startTime = arr[i][0];
                int carNum = Integer.parseInt(arr[i][1]);
                for (int j = i + 1; j < records.length; j++) {
                    if (arr[i][1].equals(arr[j][1]) && arr[j][2].equals("OUT") && !visited[j]) {
                        if (!map.containsKey(carNum)) {
                            map.put(carNum, getTime(startTime, arr[j][0]));
                            visited[j] = true;
                            isDone = true;
                        } else {
                            int time = map.get(carNum);
                            map.put(carNum, time + getTime(startTime, arr[j][0]));
                            visited[j] = true;
                            isDone = true;
                        }
                    } else if (arr[i][1].equals(arr[j][1]) && arr[j][2].equals("IN") && !visited[j]) {
                        startTime = arr[j][0];
                        visited[j] = true;
                        isDone = false;
                    }
                }
                if (!isDone) {
                    int time = map.getOrDefault(carNum, 0);
                    map.put(carNum, time + (getTime(startTime, "23:59")));
                }
            }
        }

        int[][] array = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[index][0] = entry.getKey();
            array[index][1] = getFee(entry.getValue(), fees);
            index++;
        }
        Arrays.sort(array, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i][1];
        }
        return result;
    }

    static int getTime(String start, String end) {
        return (int) Duration.between(LocalTime.parse(start), LocalTime.parse(end)).toMinutes();
    }

    static int getFee(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        }
        int result = fees[1];
        int remainTime = time - fees[0];
        result += Math.ceil((double) remainTime / fees[2]) * fees[3];
        return result;
    }
}
