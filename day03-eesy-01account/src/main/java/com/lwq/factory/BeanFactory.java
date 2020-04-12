package com.lwq.factory;

/**
 * @author lwq
 * @date 2020/4/6 -20:33
 */

import com.lwq.service.IAccountService;
import com.lwq.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;


    /**
     * 获取service代理对象
     */
    public IAccountService getAccountService() {
      return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     *
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object rtValue = null;
                        if("test".equals(method.getName())){
                            return  method.invoke(accountService,args);
                        }
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作事务
                            rtValue = method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return rtValue;

                        } catch (Exception e) {
                            //5.回滚操作
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            transactionManager.release();
                        }
                    }
                });
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
