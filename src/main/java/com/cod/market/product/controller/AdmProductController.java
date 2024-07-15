package com.cod.market.product.controller;

import com.cod.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm/product")
public class AdmProductController {
    private final ProductService productService;

    @GetMapping("/create")
    public String create() {
        return "adm/product/create";
    }

    @PostMapping("/create")
    public String createContent(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") int price,
                                MultipartFile thumbmnail) {
        productService.create(name,description,price, thumbmnail);
        return "adm/product/create";
    }
}
