package com.gk.java100;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImportInvoiceInfoHangXinVo implements Serializable, IExcelDataModel{

    private static final long serialVersionUID = 1L;
    @Excel(name = "发票种类")
    private String invoiceType;
    @Excel(name = "发票代码")
    private String invoiceCode;
    // @Excel(name = "订单号", fixedIndex = 0)
    @Excel(name = "发票号码")
    private String invoiceNo;
    @Excel(name = "开票机号")
    private String invoiceMachineNumber;
    @Excel(name = "购方名称")
    private String buyerName;
    @Excel(name = "购方税号")
    private String taxpayerIdentity;
    @Excel(name = "购方地址电话")
    private String buyerAddressTel;
    @Excel(name = "购方银行账号")
    private String buyerAccount;
    //@Excel(name = "开票日期")
    @Excel(name = "开票日期",importFormat = "yyyy-MM-dd", isImportField = "true_st")
    private Date dateIssued;
    @Excel(name = "报送状态")
    private String reportStatus;
    @Excel(name = "报送日志")
    private String reportLog;
    @Excel(name = "所属月份")
    private String reportMonth;
    @Excel(name = "合计金额")
    private java.math.BigDecimal amount;
    @Excel(name = "税率")
    private String taxRate;
    @Excel(name = "合计税额")
    private java.math.BigDecimal taxAmount;
    @Excel(name = "主要商品名称")
    private String goodsName;
    @Excel(name = "商品税目")
    private String taxItems;
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "开票人")
    private String drawer;
    @Excel(name = "收款人")
    private String payee;
    @Excel(name = "打印标志")
    private String printFlag;
    @Excel(name = "作废标志")
    private String cancelFlag;
    @Excel(name = "清单标志")
    private String detailFlag;
    @Excel(name = "修复标志")
    private String restoreFlag;
    @Excel(name = "复核人")
    private String review;
    @Excel(name = "作废日期")
    private String cancelTime;


    private String errMsg;
    private int row;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceMachineNumber() {
        return invoiceMachineNumber;
    }

    public void setInvoiceMachineNumber(String invoiceMachineNumber) {
        this.invoiceMachineNumber = invoiceMachineNumber;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getTaxpayerIdentity() {
        return taxpayerIdentity;
    }

    public void setTaxpayerIdentity(String taxpayerIdentity) {
        this.taxpayerIdentity = taxpayerIdentity;
    }

    public String getBuyerAddressTel() {
        return buyerAddressTel;
    }

    public void setBuyerAddressTel(String buyerAddressTel) {
        this.buyerAddressTel = buyerAddressTel;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportLog() {
        return reportLog;
    }

    public void setReportLog(String reportLog) {
        this.reportLog = reportLog;
    }

    public String getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTaxItems() {
        return taxItems;
    }

    public void setTaxItems(String taxItems) {
        this.taxItems = taxItems;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(String printFlag) {
        this.printFlag = printFlag;
    }

    public String getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public String getDetailFlag() {
        return detailFlag;
    }

    public void setDetailFlag(String detailFlag) {
        this.detailFlag = detailFlag;
    }

    public String getRestoreFlag() {
        return restoreFlag;
    }

    public void setRestoreFlag(String restoreFlag) {
        this.restoreFlag = restoreFlag;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Override
    public String toString() {
        return "ImportInvoiceInfoHangXinVo{" +
                "invoiceType='" + invoiceType + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceMachineNumber='" + invoiceMachineNumber + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", taxpayerIdentity='" + taxpayerIdentity + '\'' +
                ", buyerAddressTel='" + buyerAddressTel + '\'' +
                ", buyerAccount='" + buyerAccount + '\'' +
                ", dateIssued=" + dateIssued +
                ", reportStatus='" + reportStatus + '\'' +
                ", reportLog='" + reportLog + '\'' +
                ", reportMonth='" + reportMonth + '\'' +
                ", amount=" + amount +
                ", taxRate='" + taxRate + '\'' +
                ", taxAmount=" + taxAmount +
                ", goodsName='" + goodsName + '\'' +
                ", taxItems='" + taxItems + '\'' +
                ", remark='" + remark + '\'' +
                ", drawer='" + drawer + '\'' +
                ", payee='" + payee + '\'' +
                ", printFlag='" + printFlag + '\'' +
                ", cancelFlag='" + cancelFlag + '\'' +
                ", detailFlag='" + detailFlag + '\'' +
                ", restoreFlag='" + restoreFlag + '\'' +
                ", review='" + review + '\'' +
                ", cancelTime='" + cancelTime + '\'' +
                '}';
    }

    @Override
    public int getRowNum() {
        return this.row;
    }

    @Override
    public void setRowNum(int i) {
        this.row = i;
    }
}
