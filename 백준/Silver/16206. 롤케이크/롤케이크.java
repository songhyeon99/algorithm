import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> divisibleList = new ArrayList<>();
		List<Integer> nonDivisibleList= new ArrayList<>();
		int count = 0;

		for (int i = 0; i < M; i++) {
			int temp = sc.nextInt();
			if (temp % 10 == 0) {
				divisibleList.add(temp);
			} else {
				nonDivisibleList.add(temp);
			}
		}

		Collections.sort(divisibleList);
		Collections.sort(nonDivisibleList);
		
		for (int i = 0; i < divisibleList.size(); i++) {
			int number = divisibleList.get(i);
			if (number == 10) {
				count++;
			} else {
				int quotient = number / 10;
				if (N >= quotient - 1) {
					count += quotient;
					N -= (quotient - 1);
				} else {
					count += N;
					N = 0;
					break;
				}
			}
		}

		if (N > 0) {
			for (int i = 0; i < nonDivisibleList.size(); i++) {
				int number = nonDivisibleList.get(i);
				int quotient = number / 10;
				if (N >= quotient) {
					count += quotient;
					N -= quotient;
				} else {
					count += N;
					N = 0;
					break;
				}
			}
		}
		System.out.println(count);
	}
}