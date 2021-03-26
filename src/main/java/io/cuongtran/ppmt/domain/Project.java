package io.cuongtran.ppmt.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date start_date;
    private Date end_date;
    private Date created_At;
    private Date updated_At;

    public Project(){

    }


    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

}
