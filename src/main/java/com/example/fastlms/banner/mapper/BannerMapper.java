package com.example.fastlms.banner.mapper;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
}
