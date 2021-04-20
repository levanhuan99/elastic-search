package com.example.demo.models.elasticSearchModels;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.sql.Date;

@Document(indexName = "template")
public class TemplateElasticSearch {
    @Id
    @Field(type = FieldType.Text, name = "id")
    private Long id;

    @Field(type = FieldType.Text, name = "TEMPLATE_TYPE_ID")
    private int templateTypeId;

    @Field(type = FieldType.Text, name = "LABEL_ID")
    private Long labelId;

    @Field(type = FieldType.Text, name = "STATUS")
    private int status;

    @Field(type = FieldType.Text, name = "TEMPLATE_CONTENT")
    private String templateContent;

    @Field(type = FieldType.Text, name = "TOTAL_PARAM")
    private int totalParam;

    @Field(type = FieldType.Text, name = "AGENT_ID")
    private Long agentId;

    @Field(type = FieldType.Text, name = "CREATED_USER")
    private String createdUser;

    @Field(type = FieldType.Text, name = "UPDATED_USER")
    private String updatedUser;

    @Field(type = FieldType.Text, name = "CREATED_DATE")
    private Date createdDate;

    @Field(type = FieldType.Text, name = "UPDATED_DATE")
    private Date updatedDate;

    @Field(type = FieldType.Text, name = "CENSORED_USER")
    private String censoredUser;

    @Field(type = FieldType.Text, name = "CENSORED_DATE")
    private Date censoredDate;

    @Field(type = FieldType.Text, name = "PRIORITY")
    private int priority;

    @Field(type = FieldType.Text, name = "TEMPLATE_NAME")
    private String templateName;

    @Field(type = FieldType.Text, name = "AGENT_TYPE")
    private int agentType;

    @Field(type = FieldType.Text, name = "ADSER_ID")
    private Long adserId;

    @Field(type = FieldType.Text, name = "ADSER_TYPE")
    private int adserType;

    @Field(type = FieldType.Text, name = "CONTRACT_ID")
    private Long contractId;

    @Field(type = FieldType.Text, name = "CONTRACT_TYPE_ID")
    private int contractTypeId;

    @Field(type = FieldType.Text, name = "DESTROYED_DATE")
    private Date destroyedDate;

    @Field(type = FieldType.Text, name = "TEMPLATE_CONTENT_MESSAGE")
    private String templateContentMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTemplateTypeId() {
        return templateTypeId;
    }

    public void setTemplateTypeId(int templateTypeId) {
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

    public int getTotalParam() {
        return totalParam;
    }

    public void setTotalParam(int totalParam) {
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    public Long getAdserId() {
        return adserId;
    }

    public void setAdserId(Long adserId) {
        this.adserId = adserId;
    }

    public int getAdserType() {
        return adserType;
    }

    public void setAdserType(int adserType) {
        this.adserType = adserType;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public int getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(int contractTypeId) {
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
