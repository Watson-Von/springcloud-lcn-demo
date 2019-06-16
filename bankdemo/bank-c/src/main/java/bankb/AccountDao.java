package bankb;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {

    @Update("update bank_c set money = money+#{money} where user =#{user}")
    int update(Account account);

    @Insert("insert bank_c (money, user) values (#{money}, #{user})")
    int insert(Account account);
}
