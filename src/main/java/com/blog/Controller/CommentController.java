package com.blog.Controller;

import com.blog.Service.CommentService;
import com.blog.payload.CommentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    private CommentService service;



@PostMapping
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto dto,
                                           @RequestParam long id
){
     CommentDto dtos=service.findall(dto,id);
    return null;
}


}
