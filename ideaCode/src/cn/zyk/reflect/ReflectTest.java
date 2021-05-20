package cn.zyk.reflect;

import cn.zyk.domain.Person;
import cn.zyk.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//需求：写一个框架
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以chuangjian 任意类对象，可以执行任意类的方法
        //步骤
        /*
        1，将需要创建的对象的全类名和需要执行的方法定义在配置文件中
        2，在程序中加载读取配置文件
        3，使用反射技术来加载类文件进内存
        4，创建对象
        5，执行方法
         */
        //1->(1)创建Properties对象
        Properties pro=new Properties();
        //1->(2)加载配置文件,转换为一个集合
        //1->(2)->1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //获取配置文件中定义的数据:
        String className=pro.getProperty("className");
        String methodName=pro.getProperty("methodName");

        //加载该类进内存
        Class cls=Class.forName(className);
        //创建对象
        Object obj=cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
