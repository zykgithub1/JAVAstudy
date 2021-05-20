package cn.zyk.reflect;

import cn.zyk.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
//      Object person=constructor.newInstance("张三",25);//创建一个对象
        Object person = constructor.newInstance("张三", 25);
        System.out.println(person);
        Constructor constructor1 = personClass.getConstructor();
        Object person2 = constructor1.newInstance();
        System.out.println(person2);
        Object person3 = personClass.newInstance();
        System.out.println(person3);
        System.out.println(person2 == person3);
    }
}
