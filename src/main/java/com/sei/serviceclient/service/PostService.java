package com.sei.serviceclient.service;


import com.sei.serviceclient.model.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/posts")
public interface PostService {

    @GetExchange
    List<Post> getAllPosts();

    @GetExchange("/{id}")
    Post getPostById(@PathVariable  Long id);

    @PostExchange
    Post createPost(@RequestBody Post post);

}
