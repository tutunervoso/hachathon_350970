package com.neves.arthur.hackathon.Controller;

import com.neves.arthur.hackathon.Model.Review;
import com.neves.arthur.hackathon.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{cpf}")
    public List<Review> listarPagamento(@PathVariable String cpf){
        return reviewService.listarPagamentos(cpf);
    }
}
