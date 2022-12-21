package com.stengg.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String serialalphanumber;
    private String createddate;

    public Asset() {
    }


  public Asset(Long id, String name, String description, String serialalphanumber, String createddate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.serialalphanumber = serialalphanumber;
    // this.createddate = "2022-01-01";
    this.createddate = createddate;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSerialalphanumber() {
    return this.serialalphanumber;
  }

  public void setSerialalphanumber(String serialalphanumber) {
    this.serialalphanumber = serialalphanumber;
  }

  public String getCreateddate() {
    return this.createddate;
  }

  public void setCreateddate(String createddate) {
    this.createddate = createddate;
  }




  
}
