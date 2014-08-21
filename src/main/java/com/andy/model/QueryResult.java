/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.model;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: QueryResult.java, v 0.1 2014年8月21日 下午3:12:06 wb-zhangwei01 Exp $
 */
public class QueryResult<T> extends QueryBaseResult {
    private T result;

    /**
     * Getter method for property <tt>result</tt>.
     * 
     * @return property value of result
     */
    public T getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     * 
     * @param result value to be assigned to property result
     */
    public void setResult(T result) {
        this.result = result;
    }

}
