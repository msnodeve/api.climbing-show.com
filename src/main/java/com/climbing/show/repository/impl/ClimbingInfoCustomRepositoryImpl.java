package com.climbing.show.repository.impl;

import com.climbing.show.dto.request.ClimbingInfoSearchRequestDto;
import com.climbing.show.entity.ClimbingInfo;
import com.climbing.show.repository.ClimbingInfoCustomRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.climbing.show.entity.QClimbingInfo.climbingInfo;
import static com.climbing.show.entity.QClimbingLevel.climbingLevel;

public class ClimbingInfoCustomRepositoryImpl implements ClimbingInfoCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public ClimbingInfoCustomRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ClimbingInfo> searchClimbingInfos(ClimbingInfoSearchRequestDto requestDto) {
        return jpaQueryFactory
                .select(climbingInfo)
                .from(climbingInfo)
                .innerJoin(climbingLevel).on(climbingInfo.id.eq(climbingLevel.climbingInfo.id))
                .where(containsSearchString(requestDto))
                .fetch();
    }

    private BooleanExpression containsSearchString(ClimbingInfoSearchRequestDto requestDto) {
        if (!StringUtils.isEmpty(requestDto.getSearchKey()) && !StringUtils.isEmpty(requestDto.getSearchValue())) {
            return switch (requestDto.getSearchKey()) {
                case "name" -> climbingInfo.name.contains(requestDto.getSearchValue());
                default -> null;
            };
        }
        return null;
    }
}
