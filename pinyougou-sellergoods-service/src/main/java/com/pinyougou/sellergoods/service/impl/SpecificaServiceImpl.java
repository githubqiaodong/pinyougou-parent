package com.pinyougou.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.*;
import com.pinyougou.sellergoods.service.SpecificaService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2018/9/5.
 */
@Service
public class SpecificaServiceImpl implements SpecificaService {
    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult findPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        Page<TbSpecification> p = (Page<TbSpecification>)specificationMapper.selectByExample(null);
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Long[] ids) {
        for (long id : ids){
            specificationMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbSpecification tbSpecification, int page, int rows) {
        PageHelper.startPage(page, rows);
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        if (tbSpecification != null) {
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().length() > 0) {
                criteria.andSpecNameLike("%" + tbSpecification.getSpecName() + "%");
            }
        }
        Page<TbSpecification> p = (Page<TbSpecification>) specificationMapper.selectByExample(example);
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 新增规格
     * @param tbSpecification
     */
    @Override
    public void saveSp(TbSpecification tbSpecification) {

        specificationMapper.insert(tbSpecification);
        /*TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        if (tbSpecification != null) {
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().length() > 0) {
                criteria.andSpecNameGreaterThan(tbSpecification.getSpecName());
            }
        }

        TbSpecification spe = (TbSpecification) specificationMapper.selectByExample(example);*/
        //循环插入规格选项
        for(TbSpecificationOption specificationOption:tbSpecification.getSpecificationOptionList()){
            specificationOption.setSpecId(tbSpecification.getId());//设置规格ID
            specificationOptionMapper.insert(specificationOption);
        }
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public TbSpecification findOne(Long id){
        //查询规格
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        //查询规格选项列表
        TbSpecificationOptionExample example=new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);//根据规格ID查询
        List<TbSpecificationOption> optionList = specificationOptionMapper.selectByExample(example);
        //构建组合实体类返回结果
        tbSpecification.setSpecificationOptionList(optionList);
        return tbSpecification;
    }

    /**
     * 修改
     */
    @Override
    public void update(TbSpecification tbSpecification) {
            //保存修改的规格
            specificationMapper.updateByPrimaryKey(tbSpecification);//保存规格
            //删除原有的规格选项
            TbSpecificationOptionExample example=new TbSpecificationOptionExample();
            com.pinyougou.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(tbSpecification.getId());//指定规格ID为条件
            specificationOptionMapper.deleteByExample(example);//删除
            //循环插入规格选项
            for(TbSpecificationOption specificationOption:tbSpecification.getSpecificationOptionList()){
                specificationOption.setSpecId(tbSpecification.getId());
                specificationOptionMapper.insert(specificationOption);
            }
    }

    @Override
    public List<Map> specificaList() {
        return specificationOptionMapper.specificaList();
    }
}
