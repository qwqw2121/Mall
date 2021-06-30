package com.service;

import com.pojo.Param;
import com.util.ServerResponse;

public interface ParamService {
    public ServerResponse<String> addParam(Param param);
}
