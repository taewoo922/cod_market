package com.cod.market.rebate.entity;

import com.cod.market.base.entity.BaseEntity;
import com.cod.market.order.entity.Order;
import com.cod.market.order.entity.OrderItem;
import com.cod.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RebateOrderItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Order order;
    @ManyToOne(fetch = LAZY)
    private OrderItem orderItem;
    @ManyToOne(fetch = LAZY)
    private Product product;

    private int price; // 판매가
    private int payPrice; // 결제금액
    private boolean isPaid; // 결제여부
    private LocalDateTime payDate;
}
