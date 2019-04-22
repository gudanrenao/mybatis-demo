package com.zhangwenit.mybatis.demo.model;

/**
 * @Description Person:PersonLog=1:N
 * @Author ZWen
 * @Date 2019/4/19 7:00 PM
 * @Version 1.0
 **/
public class PersonLog {

    private String id;

    private String remark;
    /**
     * 对应的person.id
     */
    private Long personId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "PersonLog{" +
                "id='" + id + '\'' +
                ", remark='" + remark + '\'' +
                ", personId=" + personId +
                '}';
    }
}