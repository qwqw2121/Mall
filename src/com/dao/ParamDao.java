package com.dao;

import com.pojo.Param;

public interface ParamDao {
    public Param findParamById(int id);
    public Param findParamByParentIdAndName(int parentId,String name);
    public int insertParam(Param param);
}
