package com.wdg.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.wdg.constants.TableConstants;
import com.wdg.entity.RawDataColumn;
import com.wdg.service.RawDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: wangdaogang
 * Date: 2019/9/16
 * Description: No Description
 */
@Service
@Slf4j
public class RawDataServiceImpl implements RawDataService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public JSONObject importList(MultipartFile file, String operation) {
        JSONObject jsonObject = new JSONObject();
        try {
            //校验文件属性
            if(!checkExcelFile(file)){
                return createErrorMessage();
            }
            Workbook workBook = createWorkBook(file.getInputStream());
            Query query = new Query();
            Criteria criteria = new Criteria();
            criteria.and("operation").is(operation);
            query.addCriteria(criteria);
            List<RawDataColumn> rawDataList = mongoTemplate.find(query, RawDataColumn.class);
            jsonObject = parseExcel(workBook,rawDataList,operation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject parseExcel(Workbook workBook,List<RawDataColumn> rawDataList,String operation) {
        if(workBook.getNumberOfSheets()<1){
            return createErrorMessage();
        }
        Sheet sheetAt = workBook.getSheetAt(0);
        List<String> excelColumn = new ArrayList<>();
        //获取第一行的列值
        Row row = sheetAt.getRow(0);
        excelColumn = getExcelHeadColumn(row,excelColumn,rawDataList);
        int rowIndex = 0;
        int startRowNum = 1;
        Iterator<Row> iterator = sheetAt.iterator();
        List<JSONObject> jsonObjects = new ArrayList<>();
        while (iterator.hasNext()){
            Row next = iterator.next();
            if (rowIndex >= startRowNum) {
                JSONObject rawData = getRowData(excelColumn, next);
                if (!rawData.keySet().isEmpty()) {
                    rawData.put("line_number", rowIndex + 1);
                    rawData.put("operation", operation);
                    jsonObjects.add(rawData);
                }
            }
        }
        log.info("解析的excel数据：{}",jsonObjects);
        return new JSONObject();
    }

    private List<String> getExcelHeadColumn(Row row,List<String> excelColumn,List<RawDataColumn> rawDataList) {
        if(excelColumn == null){
            excelColumn = new ArrayList<>();
        }
        int rowNum = row.getRowNum();
        for (int i = 0; i < rowNum; i++) {
            Cell cell = row.getCell(i);
            if(cell != null){
                String s = parseHeaderRow(row, i, rawDataList);
                if(StringUtils.isNotBlank(s)){
                    excelColumn.add(s);
                }
            }
        }
        return excelColumn;
    }

    private Workbook createWorkBook(InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            return workbook;
            //return WorkBookUtil.createWorkBook(inputStream, ExcelTypeEnum.XLSX);
        } catch (Exception e) {
            Workbook workbook = new XSSFWorkbook();
            return workbook;
        }
    }

    private boolean checkExcelFile(MultipartFile file){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        if(("xls".equalsIgnoreCase(suffix)  || "xlsx".equalsIgnoreCase(suffix)) && file.getSize() >0){
            return true;
        }
        return false;
    }

    private String parseHeaderRow(Row headRow, int i, List<RawDataColumn> rawDataColumnList) {
        RawDataColumn column = rawDataColumnList.stream().filter(p -> p.getName().equalsIgnoreCase(headRow.getCell(i).getStringCellValue().replace("\n", " "))).findFirst().orElse(null);
        if (column != null) {
            return column.getFormKey();
        }
        return null;
    }
    private JSONObject createErrorMessage(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","导入文件不合法");
        jsonObject.put("success",true);
        return jsonObject;
    }

    public static String getCellFormatValue(Cell cell) {
        String cellvalue;
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        DecimalFormat df = new DecimalFormat("0");
                        cellvalue = df.format(cell.getNumericCellValue());
                    } else {
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    private JSONObject getRowData(List<String> excelColumn, Row row) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < excelColumn.size(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                try {
                    jsonObject.put(excelColumn.get(i), getCellFormatValue(cell));
                }catch (Exception e){
                    System.out.println(ExceptionUtils.getStackTrace(e));
                }
            }
        }
        return jsonObject;
    }
}
