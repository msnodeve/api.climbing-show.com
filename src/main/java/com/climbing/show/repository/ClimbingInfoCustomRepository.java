package com.climbing.show.repository;

import com.climbing.show.dto.request.ClimbingInfoSearchRequestDto;
import com.climbing.show.entity.ClimbingInfo;

import java.util.List;

public interface ClimbingInfoCustomRepository {
    List<ClimbingInfo> searchClimbingInfos(ClimbingInfoSearchRequestDto requestDto);
}
