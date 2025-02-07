package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VipRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vipRecommendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_vip_id", insertable = false, updatable = false)
    private CommentVip commentVip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Builder
    public VipRecommend(CommentVip commentVip, User user){
        this.commentVip = commentVip;
        this.user = user;
    }
}
