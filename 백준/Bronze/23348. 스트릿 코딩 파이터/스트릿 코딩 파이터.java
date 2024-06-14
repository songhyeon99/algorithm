import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int difficult1 = sc.nextInt();
		int difficult2 = sc.nextInt();
		int difficult3 = sc.nextInt();

		int N = sc.nextInt();
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for(int i = 0; i<3*N; i++){
			if(i % 3 == 0){
				max = Math.max(sum, max);
				sum = 0;
			}
			sum += (sc.nextInt() * difficult1) + (sc.nextInt() * difficult2)  + (sc.nextInt() * difficult3);
		}
		max = Math.max(sum, max);
		System.out.println(max);
	}
}