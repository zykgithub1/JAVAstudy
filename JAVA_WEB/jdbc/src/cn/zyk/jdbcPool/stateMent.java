package cn.zyk.jdbcPool;
/*
池技术：
一个容器。存放数据库连接
要用就去池里申请对象  用完后对象返回到pool里 复用
advantager：
节约资源    用户访问高效
how to realize:|👇
Interface DataSource
采用开源方式 不自己手写
C3P0：老版    DRUID：阿里巴巴提供的

获取连接：getConnection()
归还连接：如果Connection 是从连接池获取的，那么调用时用Connection.close()不会关闭连接，而是归还连接

 */


/*
C3P0实现：
1，导包  c3p0-0.9.5.2.jar  and mchange-commons-java-0.2.12.jar
2, 配置文件：
名称 c3p0.properties or c390-config.xml
路径：直接将文件放在src目录下
创建核心对象：数据库连接池对象  CombopooledDateSource
获取连接：getConnection

 */
public class stateMent {
    public static void main(String[] args) {

    }
}
