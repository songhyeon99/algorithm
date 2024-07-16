import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long M = sc.nextLong();


		if(N == 1) {
			System.out.println(1);
		}else if(N == 2){
			System.out.println(Math.min(4, (M+1)/2));
		}else if(N >= 1 && M <= 6){
				System.out.println(Math.min(4, M));
		} else{
			System.out.println(M-6+4);
		}
	}
}