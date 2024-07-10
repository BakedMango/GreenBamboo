package com.green.bamboo.domain.entity;

import com.green.bamboo.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "role", nullable = false, length = 10)
    private String role;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ChatRoom> chatRooms;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Participation> participations;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ChatMessage> chatMessages;
}
