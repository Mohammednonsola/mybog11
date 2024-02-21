package com.blog.Service;

import com.blog.payload.CommentDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommentService {
    CommentDto findall(CommentDto dto, long cid);

    void deleteComment(long id);
    public void Delete(@PathVariable long id);

    CommentDto update(long cid, long pid, CommentDto dto);
}
