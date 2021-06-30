package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import com.util.PageBean;
import com.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/find_product.do")
    @ResponseBody
    public ServerResponse<PageBean<Product>> findProducts(Integer productId,Integer partsId,int pageNum,int pageSize){
        return productService.findProduct(productId,partsId,pageNum,pageSize);
    }
}
