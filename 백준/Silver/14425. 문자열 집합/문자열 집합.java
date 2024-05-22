import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		Map<String, Boolean> map = new HashMap<>();

		sc.nextLine();

		for(int i = 0; i<N; i++){
			map.put(sc.nextLine(), true);
		}
		for(int i = 0; i<M; i++){
			String str = sc.nextLine();
			if(map.get(str) != null && map.get(str)){
				count ++;
			}
		}
		System.out.println(count);
	}
}