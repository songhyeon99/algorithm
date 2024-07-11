import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int count = 0, oddIdx = 0;
		int[] arr = new int[26];
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'A';
			arr[index]++;
		}

		for(int i = 0; i<arr.length; i++){
			if(arr[i]%2 == 1){
				count++;
				oddIdx = i;
			}
		}

		if(count > 1){
			System.out.println("I'm Sorry Hansoo");
			return;
		}else{
			for(int i = 0; i<arr.length; i++){
				for(int j =0; j<arr[i]/2; j++){
					result += (char)(i+'A');
				}
			}
		}
		System.out.print(result);
		if(count == 1) {
			System.out.print((char)(oddIdx + 'A'));
		}
		for(int i =result.length()-1; i>=0; i--){
			System.out.print(result.charAt(i));
		}
	}
}