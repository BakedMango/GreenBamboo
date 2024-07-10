package com.green.bamboo.domain.entity;

import com.green.bamboo.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chat_rooms")
@Getter
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long chatRoomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "chat_room_name", nullable = false, length = 50)
    private String chatRoomName;

    @Column(name = "chat_room_password", length = 50)
    private String chatRoomPassword;

    @Column(name = "chat_room_limit", nullable = false)
    private int chatRoomLimit = 10000;

    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
    private List<Participation> participations;

    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
    private List<ChatMessage> chatMessages;
}
