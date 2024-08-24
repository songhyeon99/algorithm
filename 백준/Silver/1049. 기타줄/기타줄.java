import java.util.Scanner;
import java.util.Arrays;
 
 
public class Main {
    public static void main(String[] args) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M =sc.nextInt();
        int min = Integer.MAX_VALUE;
 
        int[] a = new int[M];
        int[] b = new int[M];
        for(int i=0; i<M; i++){
            b[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        min = Math.min(((N/6)+1)*b[0], N*a[0]);    
        min = Math.min(min, ((N/6))*b[0] + (N%6)*a[0]);
        
        System.out.println(min);
    }
}