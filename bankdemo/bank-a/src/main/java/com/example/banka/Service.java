package com.example.banka;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author shen
 * @Date 2019/2/26 17:52
 **/
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    AccountDao accountDao;

    @Autowired
    BankBClient bankBClient;

    @Autowired
    BankCClient bankCClient;

    @LcnTransaction
    public String start(int money) {
        String user = "feng";
        String state = bankBClient.addMoney(money,user);
        if ("success".equals(state)){
            Account account =  new Account();
            account.setMoney(money);
            account.setUser(user);
            int res = accountDao.update(account);
            throw new RuntimeException("error runtime");
            //return res>0?"success":"error";
        }
        return "error";
    }


    @LcnTransaction
    public String start2(int money) {
        String user = "feng";
        String result1 = bankBClient.addMoney(money,user);
        String result2 = bankCClient.addMoney(money, user);
        return "error";
    }

    @LcnTransaction
    public String start3(int money) {

        String user = "feng";

        String result2 = bankCClient.insert(money, user);

        String result1 = bankBClient.addMoney(money,user);

        return "error";
    }

}
