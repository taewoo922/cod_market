package com.cod.market.market.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Market extends BaseEntity {
    private String name;
    private String email;
    private String info;

    @OneToOne
    private Member member;
    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE)
    private List<Product> productList;

}
