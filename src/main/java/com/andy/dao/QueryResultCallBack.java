/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.dao;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: QueryResultCallBack.java, v 0.1 2014��8��21�� ����3:28:00 wb-zhangwei01 Exp $
 */
public interface QueryResultCallBack {
    /**
     * ����У��
     */
    public void checkParams();

    /**
     * ִ�в�ѯ
     */
    public void doQuery();
}
