package com.example.fastlms.banner.service;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.entity.Banner;
import com.example.fastlms.banner.mapper.BannerMapper;
import com.example.fastlms.banner.model.BannerInput;
import com.example.fastlms.banner.model.BannerParam;
import com.example.fastlms.banner.repository.BannerRepository;
import com.example.fastlms.course.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }
    @Override
    public boolean add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .subject(parameter.getSubject())
                .regDt(LocalDateTime.now())
                .build();
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public BannerDto getById(long id) {

        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);


    }

    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());

        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setSubject(parameter.getSubject());
        banner.setUdDt(LocalDateTime.now());
        bannerRepository.save(banner);

        return true;
    }
}
