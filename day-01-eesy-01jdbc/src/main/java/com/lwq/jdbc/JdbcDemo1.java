package com.lwq.jdbc;

/**
 * @author lwq
 * @date 2020/3/28 -15:20
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *        包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：
 *       降低程序间的依赖关系
 *       实际开发中：
 *          应该做到：编译期不依赖，运行时才依赖
 *       解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二步：通过读取配置文件来获取要创建的对象全限定类名
 *
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //     1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//    2.获取连接
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eesy?useUnicode=ture&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "9527");
//    3.获取数据库的预处理对象
        PreparedStatement ps=connection.prepareCall("select *from account");
//    4.执行SQL，得到结果集
        ResultSet resultSet = ps.executeQuery();
//    5.遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
//    6.释放资源
        resultSet.close();
        ps.close();
        connection.close();
    }


}
