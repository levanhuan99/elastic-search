package com.example.demo.models.elasticSearchModels;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.sql.Date;

@Document(indexName = "template")
public class TemplateElasticSearch {

    @Field(type = FieldType.Object, name = "id")
    private Integer id;

    @Id
    @Field(type = FieldType.Object, name = "templateTypeId")
    private int templateTypeId;

    @Field(type = FieldType.Object, name = "labelId")
    private Long labelId;

    @Field(type = FieldType.Object, name = "status")
    private int status;

    @Field(type = FieldType.Object, name = "templateContent")
    private String templateContent;

    @Field(type = FieldType.Object, name = "totalParam")
    private int totalParam;

    @Field(type = FieldType.Object, name = "agentId")
    private Long agentId;

    @Field(type = FieldType.Object, name = "createdUser")
    private String createdUser;

    @Field(type = FieldType.Object, name = "updatedUser")
    private String updatedUser;

    @Field(type = FieldType.Object, name = "createdDate")
    private Long createdDate;

    @Field(type = FieldType.Object, name = "updatedDate")
    private Long updatedDate;

    @Field(type = FieldType.Object, name = "censoredUser")
    private String censoredUser;

    @Field(type = FieldType.Object, name = "censoredDate")
    private Long censoredDate;

    @Field(type = FieldType.Object, name = "priority")
    private int priority;

    @Field(type = FieldType.Object, name = "templateName")
    private String templateName;

    @Field(type = FieldType.Object, name = "agentType")
    private int agentType;

    @Field(type = FieldType.Object, name = "adserId")
    private Long adserId;

    @Field(type = FieldType.Object, name = "adserType")
    private int adserType;

    @Field(type = FieldType.Object, name = "contractId")
    private Long contractId;

    @Field(type = FieldType.Object, name = "contractTypeId")
    private int contractTypeId;

    @Field(type = FieldType.Object, name = "destroyedDate")
    private Long destroyedDate;

    @Field(type = FieldType.Object, name = "templateContentMessage")
    private String templateContentMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
