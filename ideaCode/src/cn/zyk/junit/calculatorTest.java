package cn.zyk.junit;


//单元测试：
class calculatorTest {
    public static void main(String[] args) {
        Calculator c=new Calculator();
        int result=c.add(1,2);
        System.out.println(result);
        result=c.sub(1,1);
        System.out.println(result);
    }
}
