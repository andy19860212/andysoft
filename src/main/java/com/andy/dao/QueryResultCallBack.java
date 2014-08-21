/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.dao;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: QueryResultCallBack.java, v 0.1 2014年8月21日 下午3:28:00 wb-zhangwei01 Exp $
 */
public interface QueryResultCallBack {
    /**
     * 参数校验
     */
    public void checkParams();

    /**
     * 执行查询
     */
    public void doQuery();
}
