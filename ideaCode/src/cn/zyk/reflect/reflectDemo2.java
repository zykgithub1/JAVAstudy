package cn.zyk.reflect;

import cn.zyk.domain.Person;

import java.lang.reflect.Field;

public class reflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
        //1,Field[] getFields 获取搜友public修饰的成员变量；
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field a = personClass.getField("a");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        a.set(p, "增益开");
        System.out.println(p);

        System.out.println("------------------------------------------");
        //Field[]getDeclareFields,获取所有的成员变量
        Field[] declareFields = personClass.getDeclaredFields();
        for (Field field : declareFields) {
            System.out.println(field);
        }
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限
        d.setAccessible(true);
        Object value2 = d.get(p);
        System.out.println(value2);


    }
}
