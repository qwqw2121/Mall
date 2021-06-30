package com.dao.Impl;

import com.dao.UserDao;
import com.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private QueryRunner queryRunner;
    public int CheckUserByAccount(String account){
        String sql="select count(*) as num from action_users where account=?";
        try {
           List<Long> rs=queryRunner.query(sql,new ColumnListHandler<Long>("num"),account);
           return rs.size()>0?rs.get(0).intValue():0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }

    }
    public User findUserByAccountAndPassword(String account, String password){
        String sql="select * from action_users where account=? and password=?";
        try {
            return queryRunner.query(sql,new BeanHandler<User>(User.class),account,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
