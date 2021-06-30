package com.dao.Impl;

import com.dao.ProductDao;
import com.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Resource
    private QueryRunner queryRunner;
    public int getTotalCount(Integer productId, Integer partsId) {
        String sql = " select count(*) as num from action_products where 1=1 ";
        List<Object> params = new ArrayList<>();
        if (productId != null) {
            sql += " and product_id = ? ";
            params.add(productId);
        }
        if (partsId != null) {
            sql += " and parts_id=? ";
            params.add(partsId);
        }
        try {
            return queryRunner.query(sql, new ColumnListHandler<Long>("num"), params.toArray()).get(0).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
        public List<Product> findProductsByInfo(Integer productId,Integer partsId,int startIndex,int pageSize){
            String sql=" select id,name,product_id as productId,parts_id as partsId,"+"icon_url as iconUrl,sub_images as subImages,detail,spec_param as specParam,"+"price,stock,status,is_hot as hot,"+"created,updated from action_products where 1=1 ";
            List<Object> params = new ArrayList<>();
            if (productId != null) {
                sql += " and product_id = ? ";
                params.add(productId);
            }
            if (partsId != null) {
                sql += " and parts_id=? ";
                params.add(partsId);
            }
            sql+=" limit ?,?";
            params.add(startIndex);
            params.add(pageSize);
            try {
                return queryRunner.query(sql, new BeanListHandler<Product>(Product.class),params.toArray());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return null;
        }

}
