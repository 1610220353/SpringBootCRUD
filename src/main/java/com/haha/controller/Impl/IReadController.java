package com.haha.controller.Impl;


import com.haha.util.Page;
import com.haha.util.RequestPage;
import com.haha.util.ResponseResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

/**
 * @author yaoguohong
 */
public interface IReadController<T extends Serializable, P extends Serializable> {
    ResponseResult selectByPrimaryKey(@PathVariable("id") P var1);

    List<T> select(@ModelAttribute T var1);

    Page<T> selectForPage(@ModelAttribute RequestPage var1, @ModelAttribute T var2);

    List<T> selectAll();

    List<T> selectByExample();

    Page<T> selectByExampleForPage(@ModelAttribute RequestPage var1);

    int selectCount(@ModelAttribute T var1);

    int selectCountByExample();

    boolean existsWithPrimaryKey(@PathVariable("id") P var1);
}