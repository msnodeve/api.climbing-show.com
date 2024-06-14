package com.climbing.show.validate;

import com.climbing.show.dto.request.ClimbingInfoCreateRequestDto;
import com.climbing.show.repository.ClimbingInfoRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidationClimbingInfo {
    private final ClimbingInfoRepository climbingInfoRepository;

    public void insertDuplicateValidation(ClimbingInfoCreateRequestDto requestDto) {

    }
}
