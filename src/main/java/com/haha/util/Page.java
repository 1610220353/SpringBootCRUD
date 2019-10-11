package com.haha.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author yaoguohong
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 3035157868344176539L;
    private int code;
    private int count;
    private String msg;
    private List<T> data;

    public Page(int count, List data) {
        this.code = 200;
        this.count = count;
        this.msg = "success";
        this.data = data == null ? CrudConsts.EMPTY_LIST : data;
    }

    public Page(List data) {
        this.code = 200;
        this.count = data == null ? 0 : data.size();
        this.msg = "success";
        this.data = data == null ? CrudConsts.EMPTY_LIST : data;
    }

    public int getCode() {
        return this.code;
    }

    public int getCount() {
        return this.count;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Page)) {
            return false;
        } else {
            Page<?> other = (Page)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else if (this.getCount() != other.getCount()) {
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
        return other instanceof Page;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCode();
        result = result * 59 + this.getCount();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Page(code=" + this.getCode() + ", count=" + this.getCount() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    public Page(int code, int count, String msg, List<T> data) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    public Page() {
    }
}
