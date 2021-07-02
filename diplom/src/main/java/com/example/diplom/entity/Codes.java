package com.example.diplom.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="codes")
@Data
@NoArgsConstructor
public class Codes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String art;
    @Column
    private Integer size;
}
