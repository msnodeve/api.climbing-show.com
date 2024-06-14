package com.climbing.show.controller;

import com.climbing.show.dto.request.ClimbingInfoSearchRequestDto;
import com.climbing.show.dto.response.ClimbingInfoSearchResponseDto;
import com.climbing.show.dto.request.ClimbingInfoCreateRequestDto;
import com.climbing.show.dto.response.ClimbingInfoCreateResponseDto;
import com.climbing.show.service.ClimbingInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/climbing-info")
public class ClimbingInfoController {
    private final ClimbingInfoService climbingInfoService;

    @GetMapping
    public List<ClimbingInfoSearchResponseDto> searchClimbingInfos(ClimbingInfoSearchRequestDto climbingInfoSearchRequestDto) {
        return climbingInfoService.searchClimbingInfos(climbingInfoSearchRequestDto);
    }

    @PostMapping
    public ClimbingInfoCreateResponseDto saveClimbingInfo(@Valid @RequestBody
                                                          ClimbingInfoCreateRequestDto climbingInfoCreateRequestDto) {
        return climbingInfoService.saveClimbingInfo(climbingInfoCreateRequestDto);
    }

}
