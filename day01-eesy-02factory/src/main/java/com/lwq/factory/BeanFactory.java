package com.lwq.factory;

/**
 * @author lwq
 * @date 2020/3/28 -20:01
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * <p>
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：  用java语言编写的可重用组件
 * Javabean >  实体类
 * 它就是创建我们的service和dao对象的
 * <p>
 * 第一个：需要一个配置文件来配置我们的service和dao
 * 配置的内容：唯一标识=全限定类名（key=value）
 * 第二个：通过读取配置文件中的配置内容，反射创建对象
 * <p>
 * <p>
 * 我的配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //    定义一个Properties对象
    private static Properties properties;
    //    定义一个map，用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件流的对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value放入容器中
                beans.put(key, value);
            }


        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties对象失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public  static  Object  getBean(String beanName){
        return  beans.get(beanName);
}


/*    public static Object getBean(String beanName) {
        Object bean = null;

        try {
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
