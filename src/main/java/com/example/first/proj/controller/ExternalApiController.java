package com.example.first.proj.controller;

import com.example.first.proj.model.Post;
import com.example.first.proj.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/externalApi")
public class ExternalApiController {
    private final ApiService apiService;
//NO NEED TO WRITE IF WE USE LOMLOK
//    public ExternalApiController(ApiService apiService){
//        this.apiService = apiService;
//    }

    @GetMapping("/allposts")
    public List<Post> callExternalApiForPosts(){
       return apiService.getAllPostFromExternalApi();
    }

    @GetMapping("/singlepost") // Returns only one post
    public Post callExternalApiForSinglePost() {
        return apiService.getSinglePostFromExternalApi();
    }

    @GetMapping("/totalposts") // Returns only one post
    public int gettotalPosts() {
        return apiService.gettotalPosts();
    }
}
