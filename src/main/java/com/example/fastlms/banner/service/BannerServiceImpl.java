package com.example.fastlms.banner.service;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.entity.Banner;
import com.example.fastlms.banner.mapper.BannerMapper;
import com.example.fastlms.banner.model.BannerInput;
import com.example.fastlms.banner.model.BannerParam;
import com.example.fastlms.banner.repository.BannerRepository;
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
                .openYn(parameter.getOpenYn())
                .categoryId(parameter.getCategoryId())
                .linkName(parameter.getLinkName())
                .orderBy(parameter.getOrderBy())
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
        banner.setOpenYn(parameter.getOpenYn());
        banner.setLinkName(parameter.getLinkName());
        banner.setOrderBy(parameter.getOrderBy());
        banner.setCategoryId(parameter.getCategoryId());
        banner.setLinkName(parameter.getLinkName());
        banner.setOrderBy(parameter.getOrderBy());
        banner.setSubject(parameter.getSubject());
        banner.setUdDt(LocalDateTime.now());
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {

                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;

    }
}
