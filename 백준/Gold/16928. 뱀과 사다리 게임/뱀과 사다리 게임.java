import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N + M; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }

        bfs();
        System.out.println(arr[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int location = queue.poll();
            visited[location] = true;
            for (int i = 0; i < 6; i++) {
                int currentPosition = location + dice[i];
                if (currentPosition >= 1 && currentPosition <= 100) {
                    if (map.containsKey(currentPosition)) {
                        currentPosition = map.get(currentPosition);
                    }

                    if(!visited[currentPosition]) {
                        visited[currentPosition] = true;
                        arr[currentPosition] = arr[location] + 1;
                        queue.add(currentPosition);
                    }
                }
            }
        }
    }
}