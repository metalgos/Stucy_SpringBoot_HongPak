package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@AllArgsConstructor
@ToString
@Entity // 엔티티 어노테이션이 있어야 db가 인식함
public class Article {
    @Id // db의 대표값 지정
    @GeneratedValue // 1,2,3, 자동 어노테이션
    private Long id;

    @Column // db가 인식하는 컬럼
    private String title;
    @Column
    private String content;


}
