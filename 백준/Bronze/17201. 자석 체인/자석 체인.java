import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();

		int previous = 0;

		for(int i = 0; i < str.length(); i++){
			int current = Integer.parseInt(String.valueOf(str.charAt(i)));
			if(current == previous){
				System.out.println("No");
				return;
			}
			previous = current;
		}
		System.out.println("Yes");
	}
}