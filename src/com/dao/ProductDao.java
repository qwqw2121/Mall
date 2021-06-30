package com.dao;

import com.pojo.Product;
import com.util.PageBean;
import com.util.ServerResponse;

import java.util.List;

public interface ProductDao {
    public int getTotalCount(Integer productId, Integer partsId);
    public List<Product> findProductsByInfo(Integer productId,Integer partsId,int startIndex,int pageSize);

}