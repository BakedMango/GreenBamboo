package com.green.bamboo.domain.entity;

import com.green.bamboo.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "participation")
@Getter
public class Participation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Long participationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;
}
