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
 * @version $Id: DataInit.java, v 0.1 2014��8��21�� ����3:07:21 wb-zhangwei01 Exp $
 */
public class DataInit {

    public static HashMap<String, String> data  = new HashMap<String, String>();
    public static List<String[]>            ldata = new ArrayList<String[]>();
    static {
        data.put("0", "����");
        data.put("1", "����");
        data.put("2", "�Ա�");
        data.put("3", "���");
        String[] temp =new String[4];
        temp[0]="����";
        temp[1]="����";
        temp[2]="�Ա�";
        temp[3]="���";
        
        ldata.add(temp);

    }

}
