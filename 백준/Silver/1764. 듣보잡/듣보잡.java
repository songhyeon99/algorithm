import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;

		List<String> list = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();

		sc.nextLine();
		for(int i =0; i<N; i++){
			map.put(sc.nextLine(), true);
		}

		StringBuilder sb = new StringBuilder();
		for(int i =0; i<M; i++){
			String str = sc.nextLine();
			if(map.get(str)!= null && map.get(str)){
				count++;
				list.add(str);
			}
		}

		list.sort(Comparator.naturalOrder());
		System.out.println(count);

		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}