package com.gk.java100;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("teacherEntity")
public class excelEntity implements java.io.Serializable{
    /** name */
    @Excel(name = "主讲老师", mergeVertical = true,needMerge=true,isImportField = "true_major,true_absent")
    private String name;

    @Excel(name = "备注", mergeVertical = true,needMerge=true,isImportField = "true_major,true_absent")
    private String remark;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
