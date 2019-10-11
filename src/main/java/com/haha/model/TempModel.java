package com.haha.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yaoguohong
 */
public class TempModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("id主键")
    private String id;
    @ApiModelProperty("name姓名")
    private String name;
    @ApiModelProperty("age年龄")
    private String age;
    @ApiModelProperty("sex男女，0：男，1：女")
    private Integer sex;
    @ApiModelProperty("remark备注")
    private String remark;

    public TempModel() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public Integer getSex() {
        return this.sex;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TempModel)) {
            return false;
        } else {
            TempModel other = (TempModel)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label71;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label71;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                label57: {
                    Object this$age = this.getAge();
                    Object other$age = other.getAge();
                    if (this$age == null) {
                        if (other$age == null) {
                            break label57;
                        }
                    } else if (this$age.equals(other$age)) {
                        break label57;
                    }

                    return false;
                }

                Object this$sex = this.getSex();
                Object other$sex = other.getSex();
                if (this$sex == null) {
                    if (other$sex != null) {
                        return false;
                    }
                } else if (!this$sex.equals(other$sex)) {
                    return false;
                }

                Object this$remark = this.getRemark();
                Object other$remark = other.getRemark();
                if (this$remark == null) {
                    if (other$remark == null) {
                        return true;
                    }
                } else if (this$remark.equals(other$remark)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof TempModel;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $age = this.getAge();
        result = result * 59 + ($age == null ? 43 : $age.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $remark = this.getRemark();
        result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
        return result;
    }

    public String toString() {
        return "TempModel(id=" + this.getId() + ", name=" + this.getName() + ", age=" + this.getAge() + ", sex=" + this.getSex() + ", remark=" + this.getRemark() + ")";
    }
}

