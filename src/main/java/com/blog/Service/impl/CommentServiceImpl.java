package com.blog.Service.impl;

import com.blog.Entity.Comments;
import com.blog.Entity.PostEntity;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.Repository.CommentRepository;
import com.blog.Repository.PostRepository;
import com.blog.Service.CommentService;
import com.blog.payload.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ModelMapper mapper;

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
        Comments comments = maptoEntity(dto);
        comments.setPostEntity(entity);
        Comments save = commentRepository.save(comments);
        CommentDto dto1 = maptoDto(save);


        return dto1;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void Delete(long id) {
        Comments comments = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment is alredy Deleted " + id)
        );
        commentRepository.delete(comments);

    }

    @Override
    public CommentDto update(long cid, long pid, CommentDto dto) {
        PostEntity post = repository.findById(pid).orElseThrow(
                () -> new ResourceNotFoundException("id is not Prasent" + pid)
        );
        Comments comments = commentRepository.findById(cid).orElseThrow(
                () -> new ResourceNotFoundException("id is not prasent" + cid)
        );
        Comments entity = maptoEntity(dto);
      entity.setCid(comments.getCid());
      entity.setPostEntity(post);
        Comments save = commentRepository.save(entity);

        return maptoDto(save);

    }
    public CommentDto maptoDto(Comments comments){
        CommentDto dtos = mapper.map(comments, CommentDto.class);
        return  dtos;
    }
    public Comments maptoEntity(CommentDto dto){
        Comments entity = mapper.map(dto, Comments.class);
        return  entity;
    }
}
