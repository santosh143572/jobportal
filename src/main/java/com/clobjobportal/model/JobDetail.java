package com.clobjobportal.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="job_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="discription")
    private String description;
    @Column(name="location")
    private String location;
    @Column(name="job_nature")
    private String jobNature;
    @Column(name="salary")
    private String salary;
    @Column(name="vacancy")
    private String Vacancy;



}
