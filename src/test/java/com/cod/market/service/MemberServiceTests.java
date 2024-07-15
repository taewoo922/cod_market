package com.cod.market.service;

import com.cod.market.member.service.MemberService;
import com.cod.market.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("회원가입")
    void t1 () {
        String username = "user1";
        String password = "user1";
        String email = "user1@test.com";
        String nickname = "user1";

        memberService.join(username, password, email, nickname);
    }

    @Test
    @DisplayName("강의 제품 생성")
    void test1() {
        for (int i = 1; i <= 200; i++ ) {
            String name = String.format("테스트 상품:[%03d]", i);
            int price = 100;
            String description = String.format("테스트 설명:[%03d]", i);
//            productService.create(name, description, price);
        }
    }
}
