package com.example.fastlms.banner.service;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.model.BannerInput;
import com.example.fastlms.banner.model.BannerParam;

import java.util.List;

public interface BannerService {

    /**
     * 배너 목록
     */
    List<BannerDto> list(BannerParam parameter);

    /**
     * 배너 등록
     */
    boolean add(BannerInput parameter);


    /**
     * 배너 상세정보
     * */
    BannerDto getById(long id);

    /**
     * 배너 정보수정
     */
    boolean set(BannerInput parameter);
}
