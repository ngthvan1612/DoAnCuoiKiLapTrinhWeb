package com.petshop.hibernate.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Orders", schema="dbo")
public class Order {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private Date deliveredAt;
  private Integer userId;
  

  public Order() {
    
  }
  
  public Order(Date deliveredAt, Integer userId) {
    super();
    this.deliveredAt = deliveredAt;
    this.userId = userId;
    
  }

  
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  @Column(name="CreatedOn")
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
  
  @Column(name="DeletedOn")
  public Date getDeletedOn() {
    return deletedOn;
  }

  public void setDeletedOn(Date deletedOn) {
    this.deletedOn = deletedOn;
  }
  
  @Column(name="DeliveredAt")
  public Date getDeliveredAt() {
    return deliveredAt;
  }

  public void setDeliveredAt(Date deliveredAt) {
    this.deliveredAt = deliveredAt;
  }
  
  @Column(name="UserId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  
}