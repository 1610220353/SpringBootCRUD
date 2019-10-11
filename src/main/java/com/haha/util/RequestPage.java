package com.haha.util;

import java.io.Serializable;

/**
 * @author yaoguohong
 */
public class RequestPage implements Serializable {
    private int page;
    private int limit;

    public int getPage() {
        return this.page;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RequestPage)) {
            return false;
        } else {
            RequestPage other = (RequestPage)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPage() != other.getPage()) {
                return false;
            } else {
                return this.getLimit() == other.getLimit();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof RequestPage;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
         result = result * 59 + this.getPage();
        result = result * 59 + this.getLimit();
        return result;
    }

    public String toString() {
        return "RequestPage(page=" + this.getPage() + ", limit=" + this.getLimit() + ")";
    }

    public RequestPage(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public RequestPage() {
    }
}

