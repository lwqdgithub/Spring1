package com.lwq.service.domain;

import java.io.Serializable;

/**
 * @author lwq
 * @date 2020/4/2 -20:09
 */
public class Account implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
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

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    private String name;
    private Float money;
}
