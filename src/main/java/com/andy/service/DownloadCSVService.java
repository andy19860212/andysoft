/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.andy.dao.DownloadDAO;
import com.andy.model.QueryResult;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: DownloadService.java, v 0.1 2014年8月21日 下午3:06:34 wb-zhangwei01 Exp $
 */
public class DownloadCSVService {
    private static DownloadDAO downloadDAO = new DownloadDAO();

    public static void main(String[] args) {
        QueryResult<List<String[]>> result = downloadDAO.getDownLoadList();
        ByteArrayOutputStream out;
        try {
            out = new ByteArrayOutputStream();
            Writer writer = new PrintWriter(out);
            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeAll(result.getResult());
            csvWriter.flush();
            csvWriter.close();
            FileOutputStream fo = new FileOutputStream("D:\\textcsv.csv");
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

            byte[] temp = new byte[1024];
            while ((in.read(temp)) != -1) {
                fo.write(temp);
            }

            fo.flush();

        } catch (Exception e) {
        }

        System.out.println("文件生成...");
        System.out.println(result.getResult());
    }

}
