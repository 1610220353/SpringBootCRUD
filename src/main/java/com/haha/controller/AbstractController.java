package com.haha.controller;

import com.haha.model.TempModel;
import com.haha.service.AbstractService;
import com.haha.util.Page;
import com.haha.util.RequestPage;
import com.haha.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author yaoguohong
 */
public abstract class AbstractController<S extends AbstractService,T extends Serializable,P extends Serializable>  {

    @Autowired
    protected S service;

    /**
     * 保存一个实体
     * null属性也会保存，不会使用数据库默认值
     */
    public ResponseResult insert(T bean){
        return ResponseResult.create(this.service.insert(bean));
    }

    @ApiOperation(
            value = "保存一个实体",
            notes = "只会保存数据不为null的字段值，不会使用数据库默认值"
    )
    public ResponseResult insertSelective(@RequestBody T bean) {
        return ResponseResult.create(this.service.insertSelective(bean));
    }
    @ApiOperation("根据主键删除一条记录")
    public ResponseResult deleteByPrimaryKey(@PathVariable("id") P id) {
        return ResponseResult.create(this.service.deleteByPrimaryKey(id));
    }

    @ApiOperation(
            value = "根据主键集合删除一条或多条记录",
            notes = "方法参数必须包含完整的主键属性"
    )
    public ResponseResult deleteByPrimaryKeys(@RequestParam("ids[]") Set<P> ids) {
        return ResponseResult.create(this.service.deleteByPrimaryKeys(ids));
    }
    @ApiOperation(
            value = "根据组合条件删除记录",
            notes = "自行构建Example"
    )
    public ResponseResult deleteByExample() {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return ResponseResult.create(this.service.deleteByExample(example));
    }

    @ApiOperation(
            value = "根据实体属性删除一条或多条记录",
            notes = "查询条件使用等号"
    )
    public ResponseResult delete(@ModelAttribute T bean) {
        return ResponseResult.create(this.service.delete(bean));
    }

    @ApiOperation(
            value = "根据主键更新实体全部字段",
            notes = "null值会被更新"
    )
    public ResponseResult updateByPrimaryKey(@RequestBody T bean) {
        return ResponseResult.create(this.service.updateByPrimaryKey(bean));
    }

    @ApiOperation("根据主键更新属性不为null的值")
    public ResponseResult updateByPrimaryKeySelective(@RequestBody T bean) {
        return ResponseResult.create(this.service.updateByPrimaryKeySelective(bean));
    }

    @ApiOperation("根据主键更新属性不为null的值")
    public ResponseResult updateByExample(@RequestBody T bean) {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return ResponseResult.create(this.service.updateByExample(bean, example));
    }

    @ApiOperation("根据组合条件更新属性不为null的值")
    public ResponseResult updateByExampleSelective(@RequestBody T bean) {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return ResponseResult.create(this.service.updateByExampleSelective(bean, example));
    }

    @ApiOperation(
            value = "根据主键查询一条记录",
            notes = "方法参数必须包含完整的主键属性，查询条件使用等号"
    )
    public ResponseResult selectByPrimaryKey(@PathVariable("id") P id) {
        return ResponseResult.create(this.service.selectByPrimaryKey(id));
    }

    @ApiOperation(
            value = "根据实体中的属性值进行查询多条记录",
            notes = "查询条件使用等号"
    )
    public List<T> select(@ModelAttribute T bean) {
        return this.service.select(bean);
    }

    @ApiOperation(
            value = "根据实体中的属性值进行查询",
            notes = "查询条件使用等号；返回Page"
    )
    public Page<T> selectForPage(@ModelAttribute RequestPage requestPage, @ModelAttribute T bean) {
        return this.service.selectForPage(requestPage.getPage(), requestPage.getLimit(), bean);
    }

    @ApiOperation(
            value = "查询全部结果",
            notes = "select(null)方法能达到同样的效果"
    )
    public List<T> selectAll() {
        return this.service.selectAll();
    }

    @ApiOperation(
            value = "根据组合条件查询一条或多条记录",
            notes = "自行构建Example"
    )
    public List<T> selectByExample() {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return this.service.selectByExample(example);
    }

    public Page<T> selectByExampleForPage(@ModelAttribute RequestPage requestPage) {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return this.service.selectByExampleForPage(requestPage.getPage(), requestPage.getLimit(), example);
    }

    @ApiOperation(
            value = "根据实体中的属性查询总数",
            notes = "查询条件使用等号"
    )
    public int selectCount(@ModelAttribute T bean) {
        return this.service.selectCount(bean);
    }

    @ApiOperation(
            value = "根据组合条件查询总数",
            notes = "查询条件使用等号"
    )
    public int selectCountByExample() {
        Example example = new Example(TempModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 0).andLike("name", "吴%");
        example.orderBy("name").orderBy("age").desc();
        return this.service.selectCountByExample(example);
    }

    @ApiOperation("根据主键判断是否存在记录")
    public boolean existsWithPrimaryKey(@PathVariable("id") P id) {
        return this.service.existsWithPrimaryKey(id);
    }


}
