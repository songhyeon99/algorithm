import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int A, B, count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(B);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			String currentStr = String.valueOf(current);
			char c = currentStr.charAt(currentStr.length()-1);

			if (current == A) {
				return count+1;
			}
			if(current < A){
				return -1;
			}
			if (current % 2 == 0) {
				count++;
				queue.add(current / 2);
			} else if (c - '0' == 1) {
				count++;
				queue.add(current / 10);
			}else{
				return -1;
			}
		}
		return count+1;
	}
}