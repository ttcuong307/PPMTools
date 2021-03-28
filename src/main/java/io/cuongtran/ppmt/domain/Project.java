package io.cuongtran.ppmt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String projectName;

    @NotNull
    @Column(updatable = false,unique = true)
    private String projectIdentifier;

    @NotNull
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    public Project(){

    }


    @PrePersist
    protected void onCreate(){
        this.updated_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

}
