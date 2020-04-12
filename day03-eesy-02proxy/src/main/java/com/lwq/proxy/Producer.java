package com.lwq.proxy;

/**
 * @author lwq
 * @date 2020/4/6 -18:27
 */

/**
 * 一个生产者
 */
public class Producer  implements  IProducer{
    /**
     * 销售
     * @param money
     */
    public  void saleProduct(float money){
        System.out.println("销售产品，并拿到钱"+money);
    }
    public  void  afterService(float money){
        /**
         * 售后
         */
        System.out.println("提供售后服务，并拿到钱"+money);
    }


}
