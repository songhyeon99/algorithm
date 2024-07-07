import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Long S = sc.nextLong();
		Long sum = 0L;
		int i = 1;

		while(true){
			if(sum < S) {
				sum += i;
				i++;
				if(sum + i > S){
					System.out.println(i-1);
					return;
				}else if(sum + i == S){
					System.out.println(i);
					return;
				}
			}
		}
	}
}