package com.cod.market.market.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Market extends BaseEntity {
    private String name;
    private String email;
    private String info;
    private List<Product> productList;

    @OneToOne
    private Member member;
    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE)
    private Product product;
}
