import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.length() > 3000) return;
		String max = "";
		String min = "";

		int M = 0;
		for (int i = 0 ; i < str.length(); i++) {
			if (str.charAt(i) == 'M') {
				M++;
			} else {
				if(M>0) {
					BigInteger tempMax = BigInteger.valueOf(5).multiply(BigInteger.TEN.pow(M));
					BigInteger tempMin = BigInteger.TEN.pow(M-1);
					max += String.valueOf(tempMax);
					min += String.valueOf(tempMin);
					min += String.valueOf(5);
					M = 0;
				}else{
					max += String.valueOf(5);
					min += String.valueOf(5);
				}
			}
		}
		if(M > 0){
			for(int i = 0; i<M; i++){
				max += String.valueOf(1l);
			}
			min += String.valueOf(BigInteger.TEN.pow(M-1));
		}
		System.out.println(max);
		System.out.println(min);
	}
}
