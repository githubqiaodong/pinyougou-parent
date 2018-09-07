package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 2018/9/6.
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return typeTemplateService.findPage(page, rows);
    }

    /**
     * 新增/修改
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping("/saveTemplate")
    public String saveTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){

        if(tbTypeTemplate.getId()!=null && !"".equals(tbTypeTemplate.getId())){
            /*typeTemplateService.updateTemplate(tbTypeTemplate);*/
        }else{
            typeTemplateService.saveTemplate(tbTypeTemplate);
        }
        return "1";
    }
}
