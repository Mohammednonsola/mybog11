package com.blog.Service.impl;

import com.blog.Entity.PostEntity;
import com.blog.Repository.PostRepository;
import com.blog.Service.PostService;
import com.blog.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class Serviceimpl implements PostService{


    @Autowired
    private PostRepository repository;




    @Override
    public PostDto createpost(PostDto postDto) {
     PostEntity post=new PostEntity();
     post.setTitle(postDto.getTitle());
     post.setContent(postDto.getContent());
     post.setDescription(postDto.getDescription());
        PostEntity save = repository.save(post);

        PostDto dto=new PostDto();
     dto.setContent(save.getContent());
     dto.setDescription(save.getDescription());
     dto.setTitle(save.getTitle());
        return dto;
    }
}
