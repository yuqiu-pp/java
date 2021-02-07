package com.gk.java100;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@RestController
public class AppEasyPoi
{
    private final int EXCEL_HEADROW = 1;

    @GetMapping("/poi")
    public void easyPoi() throws Exception {

        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(EXCEL_HEADROW);
        params.setConcurrentTask(true);

        // InputStream inputStream = new FileInputStream("//Volumes//work//caiwu//主讲.xlsx");
        // List<excelEntity> excelEntityList = ExcelImportUtil.importExcel(
        //         inputStream,
        //         excelEntity.class,
        //         params
        // );

        InputStream inputStream = new FileInputStream("//Volumes//work//caiwu//青//废票.xlsx");
        List<ImportInvoiceInfoHangXinVo> xinVoList = ExcelImportUtil.importExcel(
                inputStream,
                ImportInvoiceInfoHangXinVo.class,
                params
        );

        // InputStream inputStream = new FileInputStream("//Volumes//work//caiwu//航信200.xlsx");
        // params.setStartSheetIndex(0);
        //如果第一列不存在，此行则视为空行
        // params.setKeyIndex(0);
        // ExcelImportResult<ImportInvoiceInfoHangXinVo> excelEntityList = ExcelImportUtil.importExcelMore(
        //         inputStream,
        //         ImportInvoiceInfoHangXinVo.class,
        //         params
        // );

        // List<ImportInvoiceInfoHangXinVo> xinVoList = excelEntityList.getList();
        // for (int i = 0; i < invoiceInfoHangXinVoList.size(); i++) {
        //     ImportInvoiceInfoHangXinVo importInvoiceInfoHangXinVo = invoiceInfoHangXinVoList.get(i);
        //     if (!StringUtils.isEmpty(importInvoiceInfoHangXinVo.getInvoiceNo())){
        //         String remark = "";
        //         for (int j = 1; j < 5; j++) {
        //             if (i+j >= invoiceInfoHangXinVoList.size()){
        //                 break;
        //             }
        //             ImportInvoiceInfoHangXinVo invoiceInfoHangXinVoSub = invoiceInfoHangXinVoList.get(i+j);
        //             if (StringUtils.isEmpty(invoiceInfoHangXinVoSub.getInvoiceNo())
        //                     && !StringUtils.isEmpty(invoiceInfoHangXinVoSub.getRemark())){
        //                 remark += invoiceInfoHangXinVoSub.getRemark();
        //                 invoiceInfoHangXinVoList.remove(i+j);
        //             }else {
        //                 i += j-1;
        //                 break;
        //             }
        //         }
        //         // 追加
        //         if (!remark.equals("")){
        //             importInvoiceInfoHangXinVo.setRemark(importInvoiceInfoHangXinVo.getRemark()+remark);
        //         }
        //     }
        // }

        // List<ImportInvoiceInfoHangXinVo> xinVoList = excelEntityList.getList();

        ImportInvoiceInfoHangXinVo curr = new ImportInvoiceInfoHangXinVo();
        for (ImportInvoiceInfoHangXinVo xinVo : xinVoList){
        //     发票号码不空，新的一张发票
            if (!StringUtils.isEmpty(xinVo.getInvoiceNo())){
                // 将curr写入一个新表，这样新表的数据都是要写入的。如果有
                curr = xinVo;
            }
            // 发票号码空，备注不空，备注写入curr的remark
            else if (!StringUtils.isEmpty(xinVo.getRemark())){
                curr.setRemark(curr.getRemark() + xinVo.getRemark());
                // list操作会有些开销，不删也行，遍历写数据库时跳过
                // xinVoList.remove(xinVo);  不能这么干，会抛异常
            }
            else {
                // 例如：中间有个空行。  当错误行，写失败记录表；丢弃
            }
        }
        // lambda 局部类 匿名类都不能访问非final变量和参数。 这里不适合用lambda
        // ImportInvoiceInfoHangXinVo curr = new ImportInvoiceInfoHangXinVo();
        // xinVoList.forEach(xinVo -> {
        //     if (!StringUtils.isEmpty(xinVo.getInvoiceNo())){
        //         curr = xinVo;
        //     }
        //     else if (!StringUtils.isEmpty(xinVo.getRemark())){
        //         curr.setRemark(curr.getRemark() + xinVo.getRemark());
        //     }
        // });

        // 写数据库
        for (ImportInvoiceInfoHangXinVo xinVo : xinVoList){
            if (!StringUtils.isEmpty(xinVo.getInvoiceNo())){
                // 写数据库，捕获唯一索引异常，将记录写入errList
                // try {
                    System.out.println(xinVo);
                // }
                // catch (DuplicateKeyException e) {
                //     // 失败原因是发票号码重复
                //     e.printStackTrace();
                // }
                // catch (Exception e){
                    // 只记录第几行失败，因为errlist中写数据库也可能失败
                // }
            }
        }
        //
        System.out.println(xinVoList);
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello AppEasyPoi!" );
        SpringApplication.run(AppEasyPoi.class);
    }
}
