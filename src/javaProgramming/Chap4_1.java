package javaProgramming;


class TV{
    String company;
    int year, inch;
    TV(String company, int year, int inch){
        this.company=company;
        this.year=year;
        this.inch=inch;
    }

    void show(){
        System.out.println(company+"에서 만든"+year+"년형"+inch+"인치 TV");
    }
}

public class Chap4_1 {
    public static void main(String[] args) {
            TV myTV = new TV("LG", 2017,32);
            myTV.show();
        }
    }



