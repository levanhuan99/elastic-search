package com.example.demo.models.elasticSearchModels;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.sql.Date;

@Document(indexName = "template")
public class TemplateElasticSearch {

    @Field(type = FieldType.Long, name = "id")
    private Long id;

    @Id
    @Field(type = FieldType.Integer, name = "templateTypeId",nullValue = "")
    private int templateTypeId;

    @Field(type = FieldType.Long, name = "labelId",nullValue = "")
    private Long labelId;

    @Field(type = FieldType.Integer, name = "status",nullValue = "")
    private int status;

    @Field(type = FieldType.Text, name = "templateContent",nullValue = "")
    private String templateContent;

    @Field(type = FieldType.Integer, name = "totalParam",nullValue = "")
    private int totalParam;

    @Field(type = FieldType.Long, name = "agentId",nullValue = "")
    private Long agentId;

    @Field(type = FieldType.Text, name = "createdUser",nullValue = "")
    private String createdUser;

    @Field(type = FieldType.Text, name = "updatedUser",nullValue = "")
    private String updatedUser;

    @Field(type = FieldType.Long, name = "createdDate",nullValue = "")
    private Long createdDate;

    @Field(type = FieldType.Long, name = "updatedDate",nullValue = "")
    private Long updatedDate;

    @Field(type = FieldType.Text, name = "censoredUser",nullValue = "")
    private String censoredUser;

    @Field(type = FieldType.Long, name = "censoredDate",nullValue = "")
    private Long censoredDate;

    @Field(type = FieldType.Integer, name = "priority",nullValue = "")
    private int priority;

    @Field(type = FieldType.Text, name = "templateName",nullValue = "")
    private String templateName;

    @Field(type = FieldType.Integer, name = "agentType",nullValue = "")
    private int agentType;

    @Field(type = FieldType.Long, name = "adserId",nullValue = "")
    private Long adserId;

    @Field(type = FieldType.Integer, name = "adserType",nullValue = "")
    private int adserType;

    @Field(type = FieldType.Long, name = "contractId",nullValue = "")
    private Long contractId;

    @Field(type = FieldType.Integer, name = "contractTypeId",nullValue = "")
    private int contractTypeId;

    @Field(type = FieldType.Long, name = "destroyedDate",nullValue = "")
    private Long destroyedDate;

    @Field(type = FieldType.Text, name = "templateContentMessage",nullValue = "")
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCensoredUser() {
        return censoredUser;
    }

    public void setCensoredUser(String censoredUser) {
        this.censoredUser = censoredUser;
    }

    public Long getCensoredDate() {
        return censoredDate;
    }

    public void setCensoredDate(Long censoredDate) {
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

    public Long getDestroyedDate() {
        return destroyedDate;
    }

    public void setDestroyedDate(Long destroyedDate) {
        this.destroyedDate = destroyedDate;
    }

    public String getTemplateContentMessage() {
        return templateContentMessage;
    }

    public void setTemplateContentMessage(String templateContentMessage) {
        this.templateContentMessage = templateContentMessage;
    }
}
