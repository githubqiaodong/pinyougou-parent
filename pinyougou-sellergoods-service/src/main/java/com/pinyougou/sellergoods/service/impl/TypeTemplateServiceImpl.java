package com.pinyougou.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lenovo on 2018/9/6.
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;


    @Override
    public PageResult findPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        Page<TbTypeTemplate> p = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(null);
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void saveTemplate(TbTypeTemplate tbTypeTemplate) {
        typeTemplateMapper.insert(tbTypeTemplate);
    }


}
