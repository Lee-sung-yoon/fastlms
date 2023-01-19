package com.example.fastlms.course.model;

import lombok.Data;

@Data
public class CourseInput {

    long categoryId;
    long id;
    String subject;
    String keyword;
    String summary;
    String contents;
    long price;
    long salePrice;
    String saleEndDtText;

    //삭제를 위한 속성
    String idList;
}
