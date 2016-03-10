package com.pingan.Entity;

/**
 * Created by MENGHUCHENG012 on 2016/3/10.
 */

import java.util.Date;

/**
 * 装配模板表
 * Created with IntelliJ IDEA.
 * User: hurui
 * Date: 15-9-10
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class AssableEntity  extends AbstractModel {
    //========== properties ==========

    /**
     * This property corresponds to db column <tt>ID</tt>.
     */
    private String id;

    /**
     * 交换类型
     * This property corresponds to db column <tt>EXCHANGE_TYPE_ID</tt>.
     */
    private String exchangeTypeId;

    /**
     * 渠道系统ID
     * This property corresponds to db column <tt>CHANNEL_SYSTEM_ID</tt>.
     */
    private String channelSystemId;

    /**
     * 模板样式
     * Text：文本
     * Binary：二进制流
     * Map：Map形式
     * This property corresponds to db column <tt>TEMPLATE_TYPE</tt>.
     */
    private String templateType;

    /**
     * 最终模板内容
     * This property corresponds to db column <tt>TEMPLATE_CONTENT</tt>.
     */
    private String templateContent;

    /**
     * 子模板1
     * This property corresponds to db column <tt>SUB_TEMPLATE_1</tt>.
     */
    private String subTemplate1;

    /**
     * 动态URL模板
     * This property corresponds to db column <tt>SUB_TEMPLATE_2</tt>.
     */
    private String subTemplate2;

    /**
     * 报文头模板
     * This property corresponds to db column <tt>HEADER_TEMPLATE</tt>.
     */
    private String headerTemplate;

    /**
     * 消息类型
     * This property corresponds to db column <tt>MESSAGE_TYPE</tt>.
     */
    private String messageType;

    /**
     * 创建时间
     * This property corresponds to db column <tt>GMT_CREATE</tt>.
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * This property corresponds to db column <tt>GMT_MODIFIED</tt>.
     */
    private Date gmtModified;

    /**
     * 当前交易顺序标识
     * This property corresponds to db column <tt>CUR_TRANS_SEQ</tt>.
     */
    private String curTransSeq;

    /**
     * 后续交易顺序标识
     * This property corresponds to db column <tt>NEXT_TRANS_SEQ</tt>.
     */
    private String nextTransSeq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExchangeTypeId() {
        return exchangeTypeId;
    }

    public void setExchangeTypeId(String exchangeTypeId) {
        this.exchangeTypeId = exchangeTypeId;
    }

    public String getChannelSystemId() {
        return channelSystemId;
    }

    public void setChannelSystemId(String channelSystemId) {
        this.channelSystemId = channelSystemId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getSubTemplate1() {
        return subTemplate1;
    }

    public void setSubTemplate1(String subTemplate1) {
        this.subTemplate1 = subTemplate1;
    }

    public String getSubTemplate2() {
        return subTemplate2;
    }

    public void setSubTemplate2(String subTemplate2) {
        this.subTemplate2 = subTemplate2;
    }

    public String getHeaderTemplate() {
        return headerTemplate;
    }

    public void setHeaderTemplate(String headerTemplate) {
        this.headerTemplate = headerTemplate;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCurTransSeq() {
        return curTransSeq;
    }

    public void setCurTransSeq(String curTransSeq) {
        this.curTransSeq = curTransSeq;
    }

    public String getNextTransSeq() {
        return nextTransSeq;
    }

    public void setNextTransSeq(String nextTransSeq) {
        this.nextTransSeq = nextTransSeq;
    }
}
