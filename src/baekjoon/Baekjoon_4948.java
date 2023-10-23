package baekjoon;

import java.util.*;
public class Baekjoon_4948 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);



      while(true){
          int n=sc.nextInt();
          if(n==0) break;
          boolean[] arr = new boolean[2*n+1];
          arr[0]=arr[1]=true;
          for(int i=2;i<=2*n;i++){
              for(int j=2;j*i<=2*n;j++){
                  arr[i*j]=true;
              }
          }
          int count=0;
              for(int j=n+1;j<=2*n;j++){
                  if(arr[j]==false){
                      count++;
                  }
              }
          System.out.println(count);
      }
    }
}
