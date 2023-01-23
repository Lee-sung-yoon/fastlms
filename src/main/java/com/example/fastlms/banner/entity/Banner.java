package com.example.fastlms.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String linkName;
    String orderBy;
    long bannerId;
    long categoryId;
    String imagePath;
    String subject;
    @Lob
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

}
