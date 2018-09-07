package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable {
    private static final long serialVersionUID = -5963544798517861298L;

	private Long id;

    private String specName;

    private List<TbSpecificationOption> specificationOptionList;

    public TbSpecification() {
    }

    public TbSpecification(Long id, String specName, List<TbSpecificationOption> specificationOptionList) {
        this.id = id;
        this.specName = specName;
        this.specificationOptionList = specificationOptionList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}