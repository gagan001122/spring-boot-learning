package com.example.first.proj.service;

import com.example.first.proj.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ApiService {
    private final RestTemplate restTemplate;
//NO NEED TO WRITE IF WE USE LOMLOK
//    public ApiService(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }

    public List<Post> getAllPostFromExternalApi(){
        String apiURL = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.getForEntity(apiURL,Post[].class);
        return Arrays.asList(response.getBody());
    }
    public Post getSinglePostFromExternalApi(){
        String apiURL = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.getForEntity(apiURL,Post.class);
        return response.getBody();
    }
    public int gettotalPosts(){
        String apiURL = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.getForEntity(apiURL,Post[].class);
        return response.getBody() != null ? (int) Arrays.stream(response.getBody()).count() : 0;
    }
}
