package com.climbing.show.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@Table(name = "climbing_level")
@NoArgsConstructor
@AllArgsConstructor
public class ClimbingLevel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "climbing_info_id")
    private ClimbingInfo climbingInfo;

    @Column(name = "level", columnDefinition = "int", nullable = false)
    private String level;

    @Column(name = "color", columnDefinition = "varchar", length = 15, nullable = false)
    private String color;
}
