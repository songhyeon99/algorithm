import java.util.Scanner;

public class Main {

 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] sum = new long[N];
    long[] c = new long[M];
    long count = 0;

    sum[0] = sc.nextInt();
    for(int i=1; i<N; i++){
      sum[i] = sum[i-1] + sc.nextInt();
    }

    for(int i=0; i<N; i++){
      int remainder = (int)(sum[i] % M);
      if(remainder == 0) count++;
      c[remainder]++;
    }

    for(int i=0; i<M; i++){
      if(c[i]>1){
        count = count+(c[i]*(c[i]-1)/2);
      }
    }

    System.out.println(count);
  }
}
