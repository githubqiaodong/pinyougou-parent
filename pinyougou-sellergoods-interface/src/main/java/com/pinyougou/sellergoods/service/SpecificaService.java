package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2018/9/5.
 */
public interface SpecificaService {
    /**
     * 查询
     * @param page
     * @param rows
     * @return
     */
    public PageResult findPage(int page, int rows);

    /**
     * 批量删除品牌
     */
    public void delete(Long[] ids);

    /**
     * 带条件的条件查询
     */
    public PageResult findPage(TbSpecification tbSpecification, int page, int rows);
    /**
     * 新增
     */
    public void saveSp(TbSpecification tbSpecification);

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public TbSpecification findOne(Long id);

    /**
     * 修改
     */
    public void update(TbSpecification tbSpecification);

    List<Map> specificaList();
}
