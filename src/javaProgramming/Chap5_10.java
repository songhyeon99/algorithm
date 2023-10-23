package javaProgramming;

abstract class OddDetector {
    protected int n;
    public OddDetector (int n) {
        this.n = n;
    }
    public abstract boolean isOdd(); // 홀수이면 true 리턴
}
public class Chap5_10 extends OddDetector {
    public Chap5_10(int n) {
        super(n);
    }

    public boolean isOdd() {  // 이부분을 추가
        if (n % 2 == 1)
            return true;
        else
            return false;
    }


        public static void main(String[] args) {
            Chap5_10 b = new Chap5_10(10);
            System.out.println(b.isOdd());
        }
    }

