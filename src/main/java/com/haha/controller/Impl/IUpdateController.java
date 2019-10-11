package com.haha.controller.Impl;

import com.haha.util.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @author yaoguohong
 */
public interface IUpdateController<T extends Serializable> {
    ResponseResult updateByPrimaryKey(@RequestBody T var1);

    ResponseResult updateByPrimaryKeySelective(@RequestBody T var1);

    ResponseResult updateByExample(@RequestBody T var1);

    ResponseResult updateByExampleSelective(@RequestBody T var1);
}
