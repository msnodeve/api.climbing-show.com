package com.climbing.show.service;

import com.climbing.show.dto.request.ClimbingInfoCreateRequestDto;
import com.climbing.show.dto.request.ClimbingInfoSearchRequestDto;
import com.climbing.show.dto.response.ClimbingInfoCreateResponseDto;
import com.climbing.show.dto.response.ClimbingInfoSearchResponseDto;

import java.util.List;

public interface ClimbingInfoService {
    List<ClimbingInfoSearchResponseDto> searchClimbingInfos(ClimbingInfoSearchRequestDto requestDto);

    ClimbingInfoCreateResponseDto saveClimbingInfo(ClimbingInfoCreateRequestDto requestDto);
}
