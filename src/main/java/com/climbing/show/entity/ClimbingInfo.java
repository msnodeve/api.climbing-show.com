package com.climbing.show.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@Table(name = "climbing_infos")
@NoArgsConstructor
@AllArgsConstructor
public class ClimbingInfo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "climbingInfo")
    private List<ClimbingLevel> climbingLevelList = new ArrayList<>();

    @Column(name = "name", columnDefinition = "varchar", length = 100, nullable = false)
    private String name;

    @Column(name = "address_road", columnDefinition = "text", nullable = false)
    private String addressRoad;

    @Column(name = "address_lot", columnDefinition = "text")
    private String addressLot;

    @Column(name = "latitude", columnDefinition = "varchar", length = 15, nullable = false)
    private String latitude;

    @Column(name = "longitude", columnDefinition = "varchar", length = 15, nullable = false)
    private String longitude;

    @Column(name = "logo_url", columnDefinition = "text")
    private String logoUrl;
}
