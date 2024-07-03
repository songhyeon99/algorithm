import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Position> list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			list.add(new Position(sc.nextInt(), sc.nextInt()));
			for (int j = 0; j < N; j++) {
				list.add(new Position(sc.nextInt(), sc.nextInt()));
			}
			list.add(new Position(sc.nextInt(), sc.nextInt()));

			bfs();
		}
	}

	static void bfs() {
		Queue<Position> queue = new LinkedList<>();
		visited = new boolean[N+2];
		queue.add(list.get(0));
		visited[0] = true;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			for(int i = 1; i<list.size(); i++) {
				Position next = list.get(i);
				int distance = Math.abs(current.x - next.x) + Math.abs(current.y - next.y);
				int bottles = (int) Math.ceil((double) distance / 50);

				if(bottles <= 20 && !visited[i]){
					if(next.x == list.get(list.size()-1).x && next.y == list.get(list.size()-1).y){
						System.out.println("happy");
						return;
					}
					queue.add(next);
					visited[i] = true;
				}
			}
		}
		System.out.println("sad");
	}

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}