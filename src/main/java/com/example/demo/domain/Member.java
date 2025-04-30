package com.example.demo.domain;

import com.example.demo.domain.common.BaseEntity;
import com.example.demo.domain.enums.Gender;
import com.example.demo.domain.enums.MemberStatus;
import com.example.demo.domain.enums.SocialType;
import com.example.demo.domain.mapping.MemberAgree;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    //columnDefinition = "VARCHAR(10)" 이렇게 가능
    private String email;

    private Integer point;

    @Enumerated(EnumType.STRING) //enum을 entity에 적용가능함, 타입은 반드시 STRING으로 해야함
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    //enum이라서 이렇게 설정함.
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

}
