package com.climbing.show.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ClimbingInfoSearchResponseDto {
    private Long id;

    private List<ClimbingLevelSearchResponseDto> climbingLevelList;

    private String name;

    private String addressRoad;

    private String addressLot;

    private String latitude;

    private String longitude;

    private String logoUrl;
}
