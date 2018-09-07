package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return brandService.findPage(page, rows);
	}

	/**
	 * 增加
	 * @param brand
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			return new Result(true,"增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"增加失败");
		}
	}

	/**
	 * 修改的回显
	 * @param id
	 * @return
     */
	@RequestMapping("/findOne")
	public TbBrand findOne(long id){
		return brandService.findOne(id);
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			return new Result(true,"增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"增加失败");
		}
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
     */
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}

	/**
	 *条件查询
	 * @param tbBrand
     */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand, int page, int rows) {
		return brandService.findPage(tbBrand, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}

}
