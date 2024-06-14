package com.climbing.show.service.impl;

import com.climbing.show.dto.request.ClimbingInfoCreateRequestDto;
import com.climbing.show.dto.request.ClimbingInfoSearchRequestDto;
import com.climbing.show.dto.request.ClimbingLevelCreateRequestDto;
import com.climbing.show.dto.response.ClimbingInfoCreateResponseDto;
import com.climbing.show.dto.response.ClimbingInfoSearchResponseDto;
import com.climbing.show.dto.response.ClimbingLevelSearchResponseDto;
import com.climbing.show.entity.ClimbingInfo;
import com.climbing.show.entity.ClimbingLevel;
import com.climbing.show.repository.ClimbingInfoRepository;
import com.climbing.show.repository.ClimbingLevelRepository;
import com.climbing.show.service.ClimbingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClimbingInfoServiceImpl implements ClimbingInfoService {
    private final ClimbingInfoRepository climbingInfoRepository;
    private final ClimbingLevelRepository climbingLevelRepository;

    @Override
    public List<ClimbingInfoSearchResponseDto> searchClimbingInfos(ClimbingInfoSearchRequestDto requestDto) {
        // 조회
        List<ClimbingInfo> climbingInfos = climbingInfoRepository.searchClimbingInfos(requestDto);

        // 응답
        List<ClimbingInfoSearchResponseDto> climbingInfoResponseDtoList = new ArrayList<>();
        for (ClimbingInfo climbingInfo : climbingInfos) {
            List<ClimbingLevelSearchResponseDto> climbingLevelResponseDtoList = new ArrayList<>();
            for (ClimbingLevel climbingLevel : climbingInfo.getClimbingLevelList()) {
                climbingLevelResponseDtoList.add(
                        ClimbingLevelSearchResponseDto.builder()
                                .id(climbingLevel.getId())
                                .level(climbingLevel.getLevel())
                                .color(climbingLevel.getColor())
                                .build()
                );
            }
            climbingInfoResponseDtoList.add(
                ClimbingInfoSearchResponseDto.builder()
                        .id(climbingInfo.getId())
                        .climbingLevelList(climbingLevelResponseDtoList)
                        .name(climbingInfo.getName())
                        .addressRoad(climbingInfo.getAddressRoad())
                        .addressLot(climbingInfo.getAddressLot())
                        .latitude(climbingInfo.getLatitude())
                        .longitude(climbingInfo.getLongitude())
                        .logoUrl(climbingInfo.getLogoUrl())
                        .build()
            );
        }

        return climbingInfoResponseDtoList;
    }

    @Override
    public ClimbingInfoCreateResponseDto saveClimbingInfo(ClimbingInfoCreateRequestDto requestDto) {
        // validate
        ClimbingInfo findClimbingInfo = climbingInfoRepository.findByName(requestDto.getName());
        if (Objects.nonNull(findClimbingInfo)) {
            throw new RuntimeException("이미 존재하는 클라이밍장 입니다.");
        }

        // Entity 생성
        ClimbingInfo climbingInfoCreateDto = ClimbingInfo.builder()
                .name(requestDto.getName())
                .addressRoad(requestDto.getAddressRoad())
                .addressLot(requestDto.getAddressLot())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .logoUrl(requestDto.getLogoUrl())
                .build();

        ClimbingInfo climbingInfo = climbingInfoRepository.save(climbingInfoCreateDto);

        List<ClimbingLevel> climbingLevelCreatDtoList = new ArrayList<>();
        for (ClimbingLevelCreateRequestDto climbingLevel : requestDto.getLevelList()) {
            climbingLevelCreatDtoList.add(ClimbingLevel.builder()
                    .climbingInfo(climbingInfo)
                    .level(climbingLevel.getLevel())
                    .color(climbingLevel.getColor())
                    .build());
        }

        climbingLevelRepository.saveAll(climbingLevelCreatDtoList);

        // 응답
        return ClimbingInfoCreateResponseDto.builder()
                .id(climbingInfo.getId())
                .build();
    }
}
