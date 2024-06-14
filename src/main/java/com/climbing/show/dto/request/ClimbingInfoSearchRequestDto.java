package com.climbing.show.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClimbingInfoSearchRequestDto {
    private String searchKey;
    private String searchValue;
}
