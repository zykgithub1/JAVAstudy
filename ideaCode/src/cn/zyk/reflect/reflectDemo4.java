package cn.zyk.reflect;

import cn.zyk.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Method eat_method = personClass.getMethod("eat");
        Person p=new Person();
        eat_method.invoke(p);


        Method eat_methods2 = personClass.getMethod("eat", String.class);
        eat_methods2.invoke(p,"大肘子");

        System.out.println("--------------------------------");
        Method[] methods=personClass.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
    }
}
