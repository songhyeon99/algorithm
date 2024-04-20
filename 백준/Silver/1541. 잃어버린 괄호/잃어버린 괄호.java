import java.util.Scanner;

public class Main {
    static int sum = Integer.MAX_VALUE;
    static int temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] formula = sc.nextLine().split("-");

        for (int i = 0; i < formula.length; i++) {
            String[] formula2 = formula[i].split("\\+");
            temp =0;

            for (int j = 0; j < formula2.length; j++) {
                temp += Integer.parseInt(formula2[j]);
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
