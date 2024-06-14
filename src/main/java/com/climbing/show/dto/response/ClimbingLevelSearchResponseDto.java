package com.climbing.show.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClimbingLevelSearchResponseDto {
    private Long id;

    private String level;

    private String color;
}
