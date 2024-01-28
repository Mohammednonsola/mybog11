package com.blog.Service.impl;

import com.blog.Entity.Comments;
import com.blog.Entity.PostEntity;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.Repository.CommentRepository;
import com.blog.Repository.PostRepository;
import com.blog.Service.CommentService;
import com.blog.payload.CommentDto;

public class CommentServiceImpl implements CommentService {
  private PostRepository repository;
  private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository repository, CommentRepository commentRepository) {
        this.repository = repository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto findall(CommentDto dto, long cid) {
        PostEntity entity = repository.findById(cid).orElseThrow(
                () -> new ResourceNotFoundException("id is not prasent" + cid)
        );
        Comments  comments= new Comments();
        comments.setText(dto.getText());
        comments.setEmail(dto.getEmail());
        comments.setPostEntity(entity);

        CommentDto dtos=new CommentDto();
        dtos.setText(comments.getText());
        dtos.setEmail(comments.getEmail());
        return dtos;
    }
}
