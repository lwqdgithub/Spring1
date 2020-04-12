package com.lwq.proxy;

/**
 * @author lwq
 * @date 2020/4/6 -18:36
 */

/**
 * 对生产厂家要求的生产者
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public  void saleProduct(float money);

    /**
     * 售后
     */
    public  void  afterService(float money);
}
