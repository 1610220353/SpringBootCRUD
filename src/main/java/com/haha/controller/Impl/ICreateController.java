package com.haha.controller.Impl;

import com.haha.util.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @author yaoguohong
 */
public interface ICreateController<T extends Serializable> {

    ResponseResult insert(@RequestBody T var1);
    ResponseResult insertSelective(@RequestBody T var1);
}
