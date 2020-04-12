package com.lwq.service.impl;

import com.lwq.service.IAccountService;

import java.util.*;

/**
 * @author lwq
 * @date 2020/3/28 -19:34
 */

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {
     private String[] myStrs;
     private List<String> myList;
     private Set<String>  mySet;
     private Map<String,String> myMap;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    private Properties myProps;

    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(myProps);
        System.out.println(mySet);
    }
}
