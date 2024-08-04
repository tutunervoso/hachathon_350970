package com.neves.arthur.hackathon.Service;

import com.neves.arthur.hackathon.Model.Review;
import com.neves.arthur.hackathon.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review criarDescricao(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> listarPagamentos(String cpf){
        return reviewRepository.findByCpf(cpf);
    }
}
