package com.climbing.show.repository;

import com.climbing.show.entity.ClimbingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimbingInfoRepository extends JpaRepository<ClimbingInfo, Long>, ClimbingInfoCustomRepository {
    ClimbingInfo findByName(String name);
}
