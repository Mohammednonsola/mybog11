package com.blog.Service.impl;

import com.blog.Entity.PostEntity;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.Repository.PostRepository;
import com.blog.Service.PostService;
import com.blog.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class Serviceimpl implements PostService{


    @Autowired
    private PostRepository repository;




    @Override
    public PostDto createpost(PostDto postDto) {
        PostEntity entity = maptoEntity(postDto);
        PostEntity save = repository.save(entity);
        return mapToDto(save);

    }
//
    @Override
    public PostDto findbyid(long id) {
        PostEntity postEntity = repository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("id not found : "+id)
        );
        return mapToDto(postEntity);
    }

    @Override
    public List<PostDto> findalll(int pageNo, int pageSize, String sortby, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();
        Pageable request = PageRequest.of(pageNo, pageSize, sort);
        Page<PostEntity> all = repository.findAll(request);
        List<PostEntity> content = all.getContent();
        List<PostDto> collect = content.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return collect;

    }

    @Override
    public void find(long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> finddescription(String description) {
        return null;
    }

    @Override
    public PostDto update(long id, PostDto dto) {
        PostEntity byId = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("id"+id)
        );
        PostEntity entity = maptoEntity(dto);
        PostEntity save = repository.save(entity);
        PostDto dto1 = mapToDto(save);
        return dto1;
    }

    PostDto  mapToDto(PostEntity post){
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
     return dto;
  }

PostEntity maptoEntity(PostDto dto){
        PostEntity entity=new PostEntity();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
     return entity;
}

}
