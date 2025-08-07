import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		Deque<Integer> queue = new ArrayDeque<>();

		for(int i = 0; i<N; i++) {
			queue.add(Integer.valueOf(st.nextToken()));
		}

		List<Integer> list = new ArrayList<>(queue);

		Collections.sort(list);

		queue.clear();
		for (int num : list) {
			queue.addLast(num);
		}

		if(queue.size() < 2) {
			System.out.println(0);
			return;
		}

		if(queue.size() == 2) {
			System.out.println(1);
			return;
		}

		int count = 0;
		while(queue.size() > 1){
			int chain = queue.peek();
			if(chain > 0 && queue.size() > 2) {
				int first = queue.pollFirst() - 1;
				if(first > 0) queue.addFirst(first);
				int last = queue.pollLast();
				int secondLast = queue.pollLast();
				queue.addLast(last + secondLast);
				count++;
			}else{
				if(queue.size() <= 2) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
