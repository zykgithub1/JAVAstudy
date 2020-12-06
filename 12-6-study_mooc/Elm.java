class A {



    public static int x = 10;



    public static void printX() {

        System.out.print(x);

    }



}



public class Elm extends A {



    public int x = 20;



    public static void main(String[] args) {

        A a = new Elm();

        printX();

        System.out.print("和");

        System.out.print(a.x);

    }

}