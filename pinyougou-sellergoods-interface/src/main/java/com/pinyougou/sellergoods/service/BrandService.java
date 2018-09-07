package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;


/**
 * 
 * <pre>项目名称：pinyougou-sellergoods-interface    
 * 类名称：BrandService    
 * 类描述：    品牌
 * 创建人：杨志超 yangzhichao150@126.com    
 * 创建时间：2018年9月4日 下午3:49:11    
 * 修改人：杨志超 yangzhichao150@126.com     
 * 修改时间：2018年9月4日 下午3:49:11    
 * 修改备注：       
 * @version </pre>
 */
public interface BrandService {

	/**
	 * <pre>findAll(这里用一句话描述这个方法的作用)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2018年9月4日 下午3:50:10    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2018年9月4日 下午3:50:10    
	 * 修改备注： 品牌列表查询
	 * @return</pre>
	 */
	public List<TbBrand> findAll();
	
	/**
	 * <pre>findPage(品牌分页查询)
	 * 创建人：杨志超 yangzhichao150@126.com
	 * 创建时间：2018年9月4日 下午5:22:26
	 * 修改人：杨志超 yangzhichao150@126.com
	 * 修改时间：2018年9月4日 下午5:22:26
	 * 修改备注：
	 * @param page
	 * @param rows
	 * @return</pre>
	 */
	public PageResult findPage(int page, int rows);

	/**
	 * 新增品牌
	 * @param brand
     */
	void add(TbBrand brand);
	/**
	 * 修改回显品牌
	 */
	public TbBrand findOne(long id);
	/**
	 * 修改品牌
	 */
	public void update(TbBrand brand);
	/**
	 * 批量删除品牌
	 */
	public void delete(Long[] ids);
	/**
	 * 带条件的条件查询
	 */
	public PageResult findPage(TbBrand tbBrand, int page, int rows);
	/**
	 * 品牌下拉框数据
	 */
	List<Map> selectOptionList();
}
