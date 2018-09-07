package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrandExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		Page<TbBrand> p = (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(p.getTotal(), p.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

	@Override
	public TbBrand findOne(long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	/**
	 * 批量删除品牌
	 * @param ids
     */
	@Override
	public void delete(Long[] ids) {
		for (long id : ids){
			brandMapper.deleteByPrimaryKey(id);
		}
	}
	/**
	 * 带条件的条件查询
	 */
	@Override
	public PageResult findPage(TbBrand tbBrand, int page, int rows) {
		PageHelper.startPage(page, rows);
		TbBrandExample example = new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		if (tbBrand != null) {
			if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
				criteria.andNameLike("%" + tbBrand.getName() + "%");
			}
			if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
				criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
			}
		}
		Page<TbBrand> p = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(p.getTotal(), p.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		return brandMapper.selectOptionList();
	}


}
