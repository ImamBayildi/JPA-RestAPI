package com.labreport.backendlabrep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity//TableAnnotation
@Table(name = "t_table")//optional table name (default=classname)
@Data//Getter and Setter (Lombok)
// @Getter
// @Setter
// @ToString
public class t_user extends baseEntity {
    @Id//PrimaryKey
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_generator",initialValue = 100,allocationSize = 1)//100 den başla birer birer arttır
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")//identity column

    @Column(name = "ID",nullable = false,unique = true)
    private Long id;

    @Column(name = "ad",length = 100)
    private String firtName;
    @Column(name = "soyad",length = 100)
    private String lastName;

}
