package com.clobjobportal.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="jobsearch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchJob {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;
        @Column(name="name")
        private String name;
        @Column(name="password")
        private String password;


    }

