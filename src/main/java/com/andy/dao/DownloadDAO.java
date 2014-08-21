/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.andy.dao;

import java.util.HashMap;
import java.util.List;

import com.andy.db.DataInit;
import com.andy.model.QueryResult;

/**
 * 
 * @author wb-zhangwei01
 * @version $Id: DownloadDAO.java, v 0.1 2014年8月21日 下午3:33:57 wb-zhangwei01 Exp $
 */
public class DownloadDAO {
    private ResultQueryTemplate queryTemplate = new ResultQueryTemplate();

    public QueryResult<HashMap<String, String>> getDownLoadMap() {
        final QueryResult<HashMap<String, String>> result = new QueryResult<HashMap<String, String>>();
        queryTemplate.query(result, new QueryResultCallBack() {
            public void checkParams() {
            }

            public void doQuery() {
                result.setResult(DataInit.data);
                result.setSuccess(true);
            }

        });

        return result;
    }

    public QueryResult<List<String[]>> getDownLoadList() {
        final QueryResult<List<String[]>> result = new QueryResult<List<String[]>>();
        queryTemplate.query(result, new QueryResultCallBack() {
            public void checkParams() {
            }

            public void doQuery() {
                result.setResult(DataInit.ldata);
                result.setSuccess(true);
            }

        });

        return result;
    }

}
