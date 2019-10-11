package com.haha.controller.Impl;

import com.haha.util.ResponseResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Set;

/**
 * @author yaoguohong
 */
public interface IDeleteController<T extends Serializable, P extends Serializable> {
    ResponseResult deleteByPrimaryKey(@PathVariable("id") P var1);

    ResponseResult deleteByPrimaryKeys(@RequestParam("ids[]") Set<P> var1);

    ResponseResult deleteByExample();

    ResponseResult delete(@ModelAttribute T var1);
}
