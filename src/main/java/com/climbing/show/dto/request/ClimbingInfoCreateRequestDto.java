package com.climbing.show.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClimbingInfoCreateRequestDto {
    @NotEmpty(message = "매장명이 비어있습니다.")
    private String name;

    @NotEmpty(message = "도로명이 비어있습니다.")
    private String addressRoad;

    private String addressLot;

    @NotEmpty(message = "위도가 비어있습니다.")
    private String latitude;

    @NotEmpty(message = "경도가 비어있습니다.")
    private String longitude;

    private String logoUrl;

    @NotEmpty(message = "레벨아 비어있습니다.")
    private List<ClimbingLevelCreateRequestDto> levelList;
}
