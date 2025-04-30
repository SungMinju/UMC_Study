package com.example.demo.domain;

import com.example.demo.domain.common.BaseEntity;
import com.example.demo.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import javax.xml.parsers.SAXParser;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false, length = 30)
    private LocalDate deadline;

    @Column(nullable = false, length = 40)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
