package com.service;

import com.pojo.Product;
import com.util.PageBean;
import com.util.ServerResponse;

public interface ProductService {
    public ServerResponse<PageBean<Product>> findProduct(Integer productId,Integer partsId,int pageNum,int pageSize);
}
