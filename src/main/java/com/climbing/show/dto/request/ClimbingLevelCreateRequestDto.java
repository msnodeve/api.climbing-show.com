package com.climbing.show.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClimbingLevelCreateRequestDto {
    @NotEmpty(message = "레벨이 비어있습니다.")
    private String level;

    @NotEmpty(message = "색상이 비어있습니다.")
    private String color;
}
