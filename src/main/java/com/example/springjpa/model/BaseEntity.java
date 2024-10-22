package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode
// @MappedSuperclass đánh dấu đây không phải là một Entity thực sự, nhưng các class con của nó có thể là entity thực sự
public class BaseEntity {
    @Column(name = "CREATE_DATE", updatable = false)
    protected Date createDate;

    @Column(name = "CREATE_BY", updatable = false)
    protected String createBy;

    @Column(name = "UPDATE_DATE")
    @LastModifiedBy
    protected Date updateDate;

    @Column(name = "UPDATE_BY")
    protected String updateBy;

    @PrePersist
    protected void preInit() {
        this.createDate = new Date();
        this.updateDate = new Date();
        String username = ThreadContext.get("user") != null ? ThreadContext.get("user") : "Anomyus"; // or get from session
        this.createBy = username;
        this.updateBy = username;
    }

    @PreUpdate
    protected void preUpdate() {
        this.updateBy = ThreadContext.get("user") != null ? ThreadContext.get("user") : "Anomyus";
        this.updateDate = new Date();
    }

}
