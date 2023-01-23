package com.example.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {

    long id;
    long categoryId;
    String openYn;
    String linkName;
    String orderBy;
    String subject;

    //삭제를 위한
    String idList;

}
