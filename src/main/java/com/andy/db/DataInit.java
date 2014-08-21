/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.db;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: DataInit.java, v 0.1 2014年8月21日 下午3:07:21 wb-zhangwei01 Exp $
 */
public class DataInit {

    public static HashMap<String, String> data  = new HashMap<String, String>();
    public static List<String[]>            ldata = new ArrayList<String[]>();
    static {
        data.put("0", "姓名");
        data.put("1", "年龄");
        data.put("2", "性别");
        data.put("3", "身高");
        String[] temp =new String[4];
        temp[0]="姓名";
        temp[1]="年龄";
        temp[2]="性别";
        temp[3]="身高";
        
        ldata.add(temp);

    }

}
