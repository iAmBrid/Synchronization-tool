package com.isgoto.synchronous.model;

import java.io.Serializable;
import java.util.Date;


public class Content implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String text;
    private String ip;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String content) {
        this.text = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", content='" + text + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
