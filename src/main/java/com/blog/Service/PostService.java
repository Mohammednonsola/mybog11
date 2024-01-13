package com.blog.Service;

import com.blog.payload.PostDto;
public interface PostService  {
  public PostDto createpost(PostDto postDto);

  PostDto findbyid(long id);
}
