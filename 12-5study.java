import java.util.Scanner;

public class Test

{

    public static void main(String[] args)

    {

        //创建Scanner对象

        //System.in表示标准化输入，也就是键盘输入

        Scanner sc = new Scanner(System.in);

        //利用hasNextXXX()判断是否还有下一输入项

        int a = 0;

        int b = 0;

        int c = 0;

        if (sc.hasNext()) {

            a = sc.nextInt();

        }

        if (sc.hasNext()) {

            b = sc.nextInt();

        }

        if (sc.hasNext()) {

            c = sc.nextInt();

        }

        if(a==0 || b==0 || c==0)

        {

            System.out.println("输入不能为0");

            System.exit(-1);

        }



        MyNumber obj1, obj2, obj3;

        obj1=new MyNumber();
        obj1.num=a;
        obj2=new MyNumber();
        obj2.num=b;
        obj3=new MyNumber();
        obj3.num=c;
        if(obj1.num>obj2.num){
            swap(obj1,obj2);
        }
        if(obj2.num>obj3.num){
            swap(obj2,obj3);
        }
        if(obj1.num>obj2.num){
            swap(obj1,obj2);
        }
        System.out.println(obj1.num+","+obj2.num+","+obj3.num);










    }



    public static void swap(MyNumber m, MyNumber n)

    {

        if(m.num > n.num)

        {

            int s = m.num;

            m.num = n.num;

            n.num = s;

        }

    }

}



class MyNumber

{

    int num;

}