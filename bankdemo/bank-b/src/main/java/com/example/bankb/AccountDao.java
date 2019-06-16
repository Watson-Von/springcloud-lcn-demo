package com.example.bankb;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {
    @Update("update bank_b set money = money+#{money} where user =#{user}")
    int update(Account account);
}
