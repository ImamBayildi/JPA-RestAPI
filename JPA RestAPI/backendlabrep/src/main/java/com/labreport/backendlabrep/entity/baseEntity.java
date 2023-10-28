package com.labreport.backendlabrep.entity;


import java.io.Serializable;
import java.util.Date;//java.sql.Date??

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass//Ortak sınıf. baseEntity sınıfını extend eden bütün sınıflara uygulanacak
@Setter
@Getter
@ToString
public class baseEntity implements Serializable{//serializable?
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
