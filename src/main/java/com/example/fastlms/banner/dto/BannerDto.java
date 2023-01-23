package com.example.fastlms.banner.dto;

import com.example.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BannerDto {
    Long id;
    String linkName;
    String orderBy;
    long categoryId;
    long bannerId;
    String imagePath;
    String subject;
    String contents;
    String clickMovePath;
    String targetOption;
    LocalDateTime openStartDt;
    LocalDateTime closeStartDt;
    String openYn;
    String register;
    LocalDateTime regDt;
    String updater;
    LocalDateTime udDt;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .linkName(banner.getLinkName())
                .orderBy(banner.getOrderBy())
                .categoryId(banner.getCategoryId())
                .bannerId(banner.getBannerId())
                .imagePath(banner.getImagePath())
                .subject(banner.getSubject())
                .contents(banner.getContents())
                .clickMovePath(banner.getClickMovePath())
                .targetOption(banner.getTargetOption())
                .openStartDt(banner.getOpenStartDt())
                .closeStartDt(banner.getCloseStartDt())
                .openYn(banner.getOpenYn()                )
                .register(banner.getRegister())
                .regDt(banner.getRegDt())
                .updater(banner.getUpdater())
                .udDt(banner.getUdDt())
                .build();
    }
}
