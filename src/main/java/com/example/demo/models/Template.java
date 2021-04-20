package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "template")
public class Template {
    @Id
    @Column(name = "TEMPLATE_ID")
    private Long id;

    @Column(name = "TEMPLATE_TYPE_ID")
    private Integer templateTypeId;

    @Column(name = "LABEL_ID")
    private Long labelId;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "TEMPLATE_CONTENT")
    private String templateContent;

    @Column(name = "TOTAL_PARAM")
    private Integer totalParam;

    @Column(name = "AGENT_ID")
    private Long agentId;

    @Column(name = "CREATED_USER")
    private String createdUser;

    @Column(name = "UPDATED_USER")
    private String updatedUser;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "CENSORED_USER")
    private String censoredUser;

    @Column(name = "CENSORED_DATE")
    private Date censoredDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "TEMPLATE_NAME")
    private String templateName;

    @Column(name = "AGENT_TYPE")
    private Integer agentType;

    @Column(name = "ADSER_ID")
    private Long adserId;

    @Column(name = "ADSER_TYPE")
    private Integer adserType;

    @Column(name = "CONTRACT_ID")
    private Long contractId;

    @Column(name = "CONTRACT_TYPE_ID")
    private Integer contractTypeId;

    @Column(name = "DESTROYED_DATE")
    private Date destroyedDate;

    @Column(name = "TEMPLATE_CONTENT_MESSAGE")
    private String templateContentMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTemplateTypeId() {
        return templateTypeId;
    }

    public void setTemplateTypeId(Integer templateTypeId) {
        this.templateTypeId = templateTypeId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public Integer getTotalParam() {
        return totalParam;
    }

    public void setTotalParam(Integer totalParam) {
        this.totalParam = totalParam;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCensoredUser() {
        return censoredUser;
    }

    public void setCensoredUser(String censoredUser) {
        this.censoredUser = censoredUser;
    }

    public Date getCensoredDate() {
        return censoredDate;
    }

    public void setCensoredDate(Date censoredDate) {
        this.censoredDate = censoredDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public Long getAdserId() {
        return adserId;
    }

    public void setAdserId(Long adserId) {
        this.adserId = adserId;
    }

    public Integer getAdserType() {
        return adserType;
    }

    public void setAdserType(Integer adserType) {
        this.adserType = adserType;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public Date getDestroyedDate() {
        return destroyedDate;
    }

    public void setDestroyedDate(Date destroyedDate) {
        this.destroyedDate = destroyedDate;
    }

    public String getTemplateContentMessage() {
        return templateContentMessage;
    }

    public void setTemplateContentMessage(String templateContentMessage) {
        this.templateContentMessage = templateContentMessage;
    }
}
