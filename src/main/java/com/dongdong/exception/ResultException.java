package com.dongdong.exception;

import com.dongdong.common.ResultStatus;
import org.springframework.http.HttpStatus;

/**
 * @Auther: 杨伟栋
 * @Date: 2020/9/6 11:36
 * @Description: 1371690483@qq.com
 */
public class ResultException  extends RuntimeException{
    private ResultStatus resultStatus;
    private String message;

    public ResultException(ResultStatus resultStatus, String message) {
        this.resultStatus = resultStatus;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultException{" +
                "resultStatus=" + resultStatus +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
