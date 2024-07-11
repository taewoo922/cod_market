package com.cod.market.question.controller;

import com.cod.market.member.entity.Member;
import com.cod.market.member.service.MemberService;
import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import com.cod.market.question.entity.Question;
import com.cod.market.question.service.QuestionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final MemberService memberService;
    private final ProductService productService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id,
                         @RequestParam("content") String content,
                         Principal principal) {

        Member member = memberService.findByUserName(principal.getName());
        Product product = productService.getProduct(id);

        questionService.create(product, member, content);


        return String.format("redirect:/product/detail/%s", id);
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id,
                         @RequestParam("content") String content) {
        Question question = questionService.getQuestion(id);
        Product product = productService.getProduct(id);

        questionService.modify(question, content);

        return String.format("redirect:/product/detail/%s", product.getId());
    }


}
