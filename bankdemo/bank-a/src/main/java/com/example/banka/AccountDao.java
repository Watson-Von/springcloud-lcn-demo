package com.example.banka;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {

    @Update("update bank_a set money = money-#{money} where user=#{user}")
    int update(Account account);
}
