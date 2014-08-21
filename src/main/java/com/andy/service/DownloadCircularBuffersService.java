/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.andy.dao.DownloadDAO;
import com.andy.model.QueryResult;
import com.andy.util.CircularByteBuffer;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: DownloadService.java, v 0.1 2014年8月21日 下午3:06:34 wb-zhangwei01 Exp $
 */
public class DownloadCircularBuffersService {
    private static DownloadDAO downloadDAO = new DownloadDAO();

    public static void main(String[] args) {
        QueryResult<HashMap<String, String>> result = downloadDAO.getDownLoadMap();

        final HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet();
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < result.getResult().size(); i++) {
            HSSFCell cell = row.createCell(i);
            // 定义单元格为字符串类型
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            // 在单元格中输入一些内容
            cell.setCellValue(result.getResult().get(i + ""));
        }
        CircularByteBuffer cbb = new CircularByteBuffer(CircularByteBuffer.INFINITE_SIZE);
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("D:\\text.xls");
            OutputStream out = cbb.getOutputStream();
            workBook.write(out);
            out.flush();

            HSSFWorkbook wk = new HSSFWorkbook(cbb.getInputStream());
            wk.write(fo);
            fo.flush();
            out.close();
            cbb.clear();
        } catch (Exception e) {
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                }
            }
        }

        System.out.println("文件生成...");
        System.out.println(result.getResult());
    }
}
