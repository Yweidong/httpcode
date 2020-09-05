package com.dongdong.exception;

import com.dongdong.common.Result;
import com.dongdong.common.ResultStatus;

/**
 * @program: httpcode
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2020-09-05 16:43
 **/
public class ResultException  extends RuntimeException{
    private ResultStatus resultStatus;


    public ResultStatus getResultStatus() {
        return resultStatus.BAD_REQUEST;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
