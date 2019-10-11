package com.haha.service;



import com.github.pagehelper.PageHelper;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.haha.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @author yaoguohong
 */
public abstract class AbstractService<M extends Mapper<T>, T extends Serializable,P extends Serializable> {

    @Autowired
    protected M mapper;

    public AbstractService() {
    }

    public int insert(T bean) {
        return this.mapper.insert(bean);
    }

    public int insertSelective(T bean) {
        return this.mapper.insertSelective(bean);
    }

    public int deleteByPrimaryKey(P id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    public int deleteByPrimaryKeys(Collection<P> ids) {
        Iterator var2 = ids.iterator();

        while(var2.hasNext()) {
            P id = (P) var2.next();
            this.mapper.deleteByPrimaryKey(id);
        }

        return 1;
    }

    public int deleteByExample(Example example) {
        return this.mapper.deleteByExample(example);
    }

    public int delete(T bean) {
        return this.mapper.delete(bean);
    }

    public int updateByPrimaryKey(T bean) {
        return this.mapper.updateByPrimaryKey(bean);
    }

    public int updateByPrimaryKeySelective(T bean) {
        return this.mapper.updateByPrimaryKeySelective(bean);
    }

    public int updateByExample(T bean, Example example) {
        return this.mapper.updateByExample(bean, example);
    }

    public int updateByExampleSelective(T bean, Example example) {
        return this.mapper.updateByExampleSelective(bean, example);
    }

    public T selectByPrimaryKey(P id) {
        return (T)this.mapper.selectByPrimaryKey(id);
    }

    public List<T> select(T bean) {
        return this.mapper.select(bean);
    }

    public Page<T> selectForPage(Integer pageNumber, Integer pageSize, T bean) {
        com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(this.trunlatePageSize(pageNumber), this.trunlatePageSize(pageSize));
        List<T> list = this.mapper.select(bean);
        return new Page((int)startPage.getTotal(), list);
    }

    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    public List<T> selectByExample(Example e) {
        return this.mapper.selectByExample(e);
    }

    public Page<T> selectByExampleForPage(Integer pageNumber, Integer pageSize, Example example) {
        com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(this.trunlatePageNumber(pageNumber), this.trunlatePageSize(pageSize));
        List<T> select = this.mapper.selectByExample(example);
        return new Page((int)startPage.getTotal(), select);
    }

    public int selectCount(T bean) {
        return this.mapper.selectCount(bean);
    }

    public int selectCountByExample(Example example) {
        return this.mapper.selectCountByExample(example);
    }

    public boolean existsWithPrimaryKey(P id) {
        return this.mapper.existsWithPrimaryKey(id);
    }

    protected int trunlatePageNumber(Integer pageNumber) {
        return pageNumber != null && pageNumber != 0 ? pageNumber : 1;
    }

    protected int trunlatePageSize(Integer pageSize) {
        return pageSize != null && pageSize != 0 ? pageSize : 10;
    }

}
