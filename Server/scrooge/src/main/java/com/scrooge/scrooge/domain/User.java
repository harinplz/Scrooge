package com.scrooge.scrooge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(nullable = false)
    private int exp;

    @Column
    private int streak;

    @Column
    private int weekly_goal;

    @Column
    private int weekly_consum;
    // int -> Integer 로 변경하는게 좋을 것 같다.

    @CreatedDate
    private LocalDateTime joined_at;

    /* 연결 */

    // 사용자가 소유한 아바타 목록
    @OneToMany(mappedBy = "user")
    private List<UserOwningAvatar> userOwningAvatars = new ArrayList<>();

    // 소비 내역
    @OneToMany(mappedBy = "user")
    private List<PaymentHistory> paymentHistories = new ArrayList<>();
}