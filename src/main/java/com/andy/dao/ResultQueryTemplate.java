/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.dao;

import com.andy.model.QueryBaseResult;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: ResultQueryTemplate.java, v 0.1 2014年8月21日 下午3:21:41 wb-zhangwei01 Exp $
 */
public class ResultQueryTemplate {

    /**
     * 查询模板处理流程
     * <br>1.参数校验；
     * <br>2.执行查询；
     * <br>3.异常处理；
     * 
     * @param result 查询结果
     * @param queryCallBack 查询回调接口
     */
    public void query(QueryBaseResult result, QueryResultCallBack queryCallBack) {

        try {
            //1、参数校验
            queryCallBack.checkParams();

            //2、执行查询
            queryCallBack.doQuery();

            //3、补全查询结果
            if (result.isSuccess()) {
                result.setResultCode("SUCCESS");
                result.setResultMsg("查询成功!");
            }

        } catch (Exception e) {
            result.setSuccess(false);
            result.setResultCode("FAIL");
            result.setResultMsg("查询失败");
        }
    }

}
