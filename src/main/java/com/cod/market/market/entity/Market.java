package com.cod.market.market.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Market extends BaseEntity {
    private Member member;
    private Product product;
    private String name;
    private String email;
    private String info;

    private List<Product> productList;
}
