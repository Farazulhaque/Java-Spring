package com.practice.blogapp.services;

import java.util.List;

import com.practice.blogapp.payloads.PostDto;
import com.practice.blogapp.payloads.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postid);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostsByCategory(Integer categoryId);

    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);

}
