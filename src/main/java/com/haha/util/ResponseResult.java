package com.haha.util;

import java.io.Serializable;

/**
 * @author yaoguohong
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private boolean success;
    private String msg;
    private T data;

    public static <T> ResponseResult<T> ok() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        return responseResult;
    }

    public static <T> ResponseResult<T> fail() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        return responseResult;
    }

    public static <T> ResponseResult<T> create(int record) {
        return new ResponseResult(record);
    }

    public static <T> ResponseResult<T> create(int code, String msg) {
        return new ResponseResult(code, msg);
    }

    public static <T> ResponseResult<T> create(int record, int code, String msg) {
        return new ResponseResult(record, code, msg);
    }

    public static <T> ResponseResult<T> create(T data) {
        return new ResponseResult(data);
    }

    public ResponseResult(int record) {
        this.success = record > 0;
    }

    public ResponseResult(int code, String msg) {
        this.success = code > 0;
        this.msg = msg;
    }

    public ResponseResult(int record, int code, String msg) {
        this.success = record > 0;
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(T data) {
        this.success = true;
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseResult)) {
            return false;
        } else {
            ResponseResult<?> other = (ResponseResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label40: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label40;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label40;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
         result = result * 59 + this.getCode();
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseResult(code=" + this.getCode() + ", success=" + this.isSuccess() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    public ResponseResult() {
    }
}
