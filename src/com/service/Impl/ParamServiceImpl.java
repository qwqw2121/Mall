package com.service.Impl;

import com.dao.ParamDao;
import com.pojo.Param;
import com.service.ParamService;
import com.util.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParamServiceImpl implements ParamService {
    @Autowired
    private ParamDao paramDao;
    @Override
    public ServerResponse<String> addParam(Param param) {
            if(StringUtils.isBlank(param.getName())){
            ServerResponse.createByErrorMessage("参数异常");
        }
        Param param1=paramDao.findParamByParentIdAndName(param.getParent_id(),param.getName());
        if(param1!=null){
            return ServerResponse.createByErrorMessage("商品类型已存在");
        }
        param.setStatus(true);
        param.setCreated(new Date());
        param.setUpdated(new Date());
        param.setLevel(this.getParamLevel(param.getParent_id()));
        int rs=paramDao.insertParam(param);
        if(rs>0){
            return ServerResponse.createBySuccessMessage("新增类型成功");
        }
        return ServerResponse.createByErrorMessage("新增类型失败");
    }
    private int getParamLevel(int parentId){
        Param param=paramDao.findParamById(parentId);
        if(param!=null){
            return param.getLevel()+1;
        }
        return 0;
    }
}
