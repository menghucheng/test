//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pingan.Entity;

import java.util.Date;

public class ParserEntity extends AbstractModel {
    private String id;
    private String channelSystemId;
    private String exchangeTypeId;
    private String groovyContent;
    private String memo;
    private Date gmtCreate;
    private Date gmtModified;
    private String groovyClassName;
    private String curTransSeq;
    private String nextTransSeq;

    public ParserEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelSystemId() {
        return this.channelSystemId;
    }

    public void setChannelSystemId(String channelSystemId) {
        this.channelSystemId = channelSystemId;
    }

    public String getExchangeTypeId() {
        return this.exchangeTypeId;
    }

    public void setExchangeTypeId(String exchangeTypeId) {
        this.exchangeTypeId = exchangeTypeId;
    }

    public String getGroovyContent() {
        return this.groovyContent;
    }

    public void setGroovyContent(String groovyContent) {
        this.groovyContent = groovyContent;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGroovyClassName() {
        return this.groovyClassName;
    }

    public void setGroovyClassName(String groovyClassName) {
        this.groovyClassName = groovyClassName;
    }

    public String getCurTransSeq() {
        return this.curTransSeq;
    }

    public void setCurTransSeq(String curTransSeq) {
        this.curTransSeq = curTransSeq;
    }

    public String getNextTransSeq() {
        return this.nextTransSeq;
    }

    public void setNextTransSeq(String nextTransSeq) {
        this.nextTransSeq = nextTransSeq;
    }
}
