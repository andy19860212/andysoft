/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.andy.dao.DownloadDAO;
import com.andy.model.QueryResult;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: DownloadService.java, v 0.1 2014��8��21�� ����3:06:34 wb-zhangwei01 Exp $
 */
public class DownloadPipedService {
    private static DownloadDAO downloadDAO = new DownloadDAO();

    public static void main(String[] args) {
        QueryResult<HashMap<String, String>> result = downloadDAO.getDownLoadMap();

        final HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet();
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < result.getResult().size(); i++) {
            HSSFCell cell = row.createCell(i);
            // ���嵥Ԫ��Ϊ�ַ�������
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            // �ڵ�Ԫ��������һЩ����
            cell.setCellValue(result.getResult().get(i + ""));
        }
        try {
            FileOutputStream fo = null;
            PipedInputStream in = new PipedInputStream();
            final PipedOutputStream fOut = new PipedOutputStream(in);
            // ����Ӧ��Excel ����������

            fo = new FileOutputStream("D:\\text1.xls");
            new Thread(new Runnable() {

                public void run() {
                    try {
                        workBook.write(fOut);
                        fOut.flush();
                    } catch (IOException e) {
                    }

                }
            }).start();

            HSSFWorkbook wk = new HSSFWorkbook(in);
            wk.write(fo);
            fo.flush();
            in.close();
            fOut.close();
            fo.close();
        } catch (IOException e) {
        }

        System.out.println("�ļ�����...");
        System.out.println(result.getResult());
    }
}
