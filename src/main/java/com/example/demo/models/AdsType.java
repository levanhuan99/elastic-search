package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "ADS_TYPE")
public class AdsType {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME_TYPE")
    private String nameType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
