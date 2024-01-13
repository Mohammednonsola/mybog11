package com.blog.Controller;

import com.blog.Service.PostService;
import com.blog.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService service;


 @PostMapping
    public ResponseEntity<PostDto> Post(@RequestBody  PostDto postDto){
    PostDto dto=service.createpost(postDto);

    return  new ResponseEntity<>(dto, HttpStatus.CREATED);

 }
 @GetMapping
public ResponseEntity<PostDto> PostFindbyid(@RequestParam long id){
     service.findbyid(id);
     return null;
 }

}
