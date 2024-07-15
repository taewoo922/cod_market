package com.cod.market.product.service;

import com.cod.market.security.exception.DataNotFoundException;
import com.cod.market.product.entity.Product;
import com.cod.market.product.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Value("${custom.genFileDirPath}")
    public String genFileDirPath;

    public Page<Product> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 8, Sort.by(sorts));

        return productRepository.findAllByKeyword(kw, pageable);
    }

    public void create(String name, String description, int price, MultipartFile thumbnail) {
        String thumbnailRelPath = genFileDirPath;

        try{
            thumbnail.transferTo(new File(genFileDirPath+"/1.jpg"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }


        Product p = Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .thumbnailImg(thumbnailRelPath)
                .build();

        productRepository.save(p);
    }


    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new DataNotFoundException("product not found");
        }
    }
}
