/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.dao;

import com.andy.model.QueryBaseResult;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: ResultQueryTemplate.java, v 0.1 2014��8��21�� ����3:21:41 wb-zhangwei01 Exp $
 */
public class ResultQueryTemplate {

    /**
     * ��ѯģ�崦������
     * <br>1.����У�飻
     * <br>2.ִ�в�ѯ��
     * <br>3.�쳣����
     * 
     * @param result ��ѯ���
     * @param queryCallBack ��ѯ�ص��ӿ�
     */
    public void query(QueryBaseResult result, QueryResultCallBack queryCallBack) {

        try {
            //1������У��
            queryCallBack.checkParams();

            //2��ִ�в�ѯ
            queryCallBack.doQuery();

            //3����ȫ��ѯ���
            if (result.isSuccess()) {
                result.setResultCode("SUCCESS");
                result.setResultMsg("��ѯ�ɹ�!");
            }

        } catch (Exception e) {
            result.setSuccess(false);
            result.setResultCode("FAIL");
            result.setResultMsg("��ѯʧ��");
        }
    }

}
