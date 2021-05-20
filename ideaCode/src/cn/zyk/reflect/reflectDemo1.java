package cn.zyk.reflect;

import cn.zyk.domain.Person;

public class reflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1=Class.forName("cn.zyk.domain.Person");
        System.out.println(cls1);

        Class cls2=Person.class;
        System.out.println(cls2);
        Person p=new Person();
        Class cls3=p.getClass();

        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);
        System.out.println(cls1.arrayType());

    }
}
