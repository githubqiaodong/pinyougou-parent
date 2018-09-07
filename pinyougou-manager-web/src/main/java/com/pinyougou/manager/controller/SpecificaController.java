package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificaService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2018/9/5.
 */
@RestController
@RequestMapping("/specifica")
public class SpecificaController {
    @Reference
    private SpecificaService specificaService;

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return specificaService.findPage(page, rows);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificaService.delete(ids);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败！");
        }
    }

    /**
     *条件查询
     * @param
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbSpecification tbSpecification, int page, int rows) {
        return specificaService.findPage(tbSpecification, page, rows);
    }

    /**
     * 新增规格
     */
    @RequestMapping("/saveSp")
    public Result saveSp(@RequestBody TbSpecification tbSpecification){
        try {
            specificaService.saveSp(tbSpecification);
            return new Result(true, "新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败！");
        }
    }
    @RequestMapping("/findOne")
    public TbSpecification findOne(Long id){
        return specificaService.findOne(id);
    }

    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbSpecification tbSpecification){
        try {
            specificaService.update(tbSpecification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * specificaList
     */
    @RequestMapping("/specificaList")
    public List<Map> specificaList(){
        return specificaService.specificaList();
    }
}
