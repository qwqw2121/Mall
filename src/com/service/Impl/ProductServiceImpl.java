package com.service.Impl;

import com.dao.ProductDao;
import com.pojo.Product;
import com.service.ProductService;
import com.util.PageBean;
import com.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public ServerResponse<PageBean<Product>> findProduct(Integer productId, Integer partsId, int pageNum, int pageSize) {
        int totalCount=productDao.getTotalCount(productId,partsId);
        PageBean<Product> pageBean=new PageBean<>(pageNum,pageSize,totalCount);
        pageBean.setData(productDao.findProductsByInfo(productId,partsId,pageBean.getStartIndex(),pageSize));
        return ServerResponse.createBySuccess(pageBean);
    }

}
