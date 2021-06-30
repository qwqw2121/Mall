package com.dao.Impl;

import com.dao.ParamDao;
import com.pojo.Param;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.sql.SQLException;

@Repository
public class ParamDaoImpl implements ParamDao {
    @Resource
    private QueryRunner queryRunner;
    @Override
    public Param findParamById(int id) {
        String sql = " select * from action_params where id=? ";
        try {
            return queryRunner.query(sql, new BeanHandler<Param>(Param.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Param findParamByParentIdAndName(int parentId, String name) {
        String sql = " select * from action_params where parent_id=? and name=? ";
        try {
            return queryRunner.query(sql, new BeanHandler<Param>(Param.class),parentId,name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public int insertParam(Param param) {
        String sql=" insert into action_params(parent_id,name,sort_order,status,level,created,updated) values(?,?,?,?,?,?,?)";
        Object[] params={param.getParent_id(),param.getName(),param.getSort_order(),param.getStatus(),param.getLevel(),param.getCreated(),param.getUpdated()};
        try {
            return queryRunner.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
}
