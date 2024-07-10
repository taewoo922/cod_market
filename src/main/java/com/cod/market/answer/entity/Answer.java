package com.cod.market.answer.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.question.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Answer extends BaseEntity {
    private String subject;
    private String content;

    @OneToOne
    private Member member;
    @OneToOne
    private Question question;

}
