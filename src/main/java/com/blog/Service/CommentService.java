package com.blog.Service;

import com.blog.payload.CommentDto;

public interface CommentService {
    CommentDto findall(CommentDto dto, long cid);
}
