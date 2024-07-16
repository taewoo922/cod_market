package com.cod.market.answer.entity;

import com.cod.market.base.entity.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.question.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends BaseEntity {
    private String subject;
    private String content;

    @OneToOne
    private Member member;
    @OneToOne
    private Question question;

}
