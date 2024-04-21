import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int left = 0, right = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            right += arr[i];
            if(left < arr[i]) left = arr[i];
        }

        while(left <= right){
            int sum = 0, count = 0;
            int mid = (left + right) / 2;
            for(int i=0; i<N; i++){
                if(sum + arr[i] > mid){
                    sum = 0;
                    count ++;
                }
                sum += arr[i];
            }

            if(sum != 0) count++;

            if(count > M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

}
