package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

/**
 * Created by Lenovo on 2018/9/6.
 */
public interface TypeTemplateService {
    public PageResult findPage(int page, int rows);

    public void saveTemplate(TbTypeTemplate tbTypeTemplate);
}
