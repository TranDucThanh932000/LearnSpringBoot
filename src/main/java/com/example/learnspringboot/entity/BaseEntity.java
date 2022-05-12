package com.example.learnspringboot.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

//MappedSuperclass để những thằng con kế thừa class này khi generate cũng sẽ generate thuộc tính của cả thằng cha nữa
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // có nghĩa là nếu mình muốn tên khác thì mình nhập name mình thích, k thì để nguyên @Column thì nó tự
    // mapping với name property mình đặt
    @CreatedBy
    @Column
    private String createdBy;
    @CreatedDate
    @Column
    private Date createdDate;
    @LastModifiedBy
    @Column
    private String modifiedBy;
    @LastModifiedDate
    @Column
    private Date modifiedDate;


    public Long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createdDate == null) createdDate = new Date();
        if (this.modifiedDate == null) modifiedDate = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.modifiedDate = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.modifiedDate = new Date();
    }
}
