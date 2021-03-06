package com.lwq.domain;

import java.io.Serializable;

/**
 * @author lwq
 * @date 2020/4/8 -13:21
 */

/**
 * 账户的实体类
 */
public class Account implements Serializable {
    private  Integer id;
    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    private float money;

    @Override
    public String  toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
