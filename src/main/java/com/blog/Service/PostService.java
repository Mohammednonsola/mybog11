package com.blog.Service;

import com.blog.payload.PostDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService  {
  public PostDto createpost(PostDto postDto);
//
  PostDto findbyid(long id);
//
  List<PostDto> findalll(int pageNo, int pageSize);


  void find(long id);


  ResponseEntity<?> finddescription(String description);

  PostDto update(long id, PostDto dto);
}
