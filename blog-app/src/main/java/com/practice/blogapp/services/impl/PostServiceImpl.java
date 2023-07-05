package com.practice.blogapp.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.blogapp.entities.Category;
import com.practice.blogapp.entities.Post;
import com.practice.blogapp.entities.User;
import com.practice.blogapp.exceptions.ResourceNotFoundException;
import com.practice.blogapp.payloads.PostDto;
import com.practice.blogapp.repositories.CategoryRepo;
import com.practice.blogapp.repositories.PostRepo;
import com.practice.blogapp.repositories.UserRepo;
import com.practice.blogapp.services.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post post = modelMapper.map(postDto, Post.class);

        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = postRepo.save(post);

        PostDto postDto2 = modelMapper.map(newPost, PostDto.class);

        return postDto2;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public List<PostDto> getAllPost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPost'");
    }

    @Override
    public PostDto getPostById(Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        List<Post> posts = postRepo.findByCategory(category);
        List<PostDto> postDtos = posts.stream().map((post) -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        List<Post> posts = postRepo.findByUser(user);
        for (Post post : posts) {
            System.out.println(post);
        }
        List<PostDto> postDtos = posts.stream().map((post) -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        for (PostDto post : postDtos) {
            System.out.println(post);
        }
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");

    }

}
