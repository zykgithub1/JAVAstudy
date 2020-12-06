class NumTest{

    final static int num1 = 1;

    static int num2 = 1;



    void printNum1(){

        System.out.print(num1+" ");

    }



    void printNum2(){

        System.out.print(num2+" ");

    }



    public static void main(String[] args) {

        NumTest a = new NumTest();

        a.num2 ++;

        a.printNum1();

        NumTest b = new NumTest();

        b.printNum2();

    }

}