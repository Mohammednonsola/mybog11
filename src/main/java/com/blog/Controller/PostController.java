package com.blog.Controller;

import com.blog.Employees;
import com.blog.Entity.PostEntity;
import com.blog.Service.PostService;
import com.blog.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {
  private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> Post(@RequestBody  PostDto postDto){
    PostDto dto=service.createpost(postDto);

    return  new ResponseEntity<>(dto, HttpStatus.CREATED);

 }
 @GetMapping
public ResponseEntity<PostDto> PostFindbyid(@RequestParam long id){
     PostDto findbyid = service.findbyid(id);
     return new ResponseEntity<>(findbyid,HttpStatus.INTERNAL_SERVER_ERROR);
 }

//    localhost:8080/api/post/?PageNo=0&PageSize=15&sortby=content
 @GetMapping("/")
    public List<PostDto> findall(
            @RequestParam(name = "PageNo",required = false,defaultValue = "0") int PageNo,
            @RequestParam(name = "PageSize",required = false,defaultValue = "3") int PageSize,
            @RequestParam(name = "sortby",required = false,defaultValue = "id") String sortby,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir

 ){
     List<PostDto> findalll = service.findalll(PageNo,PageSize,sortby,sortDir);

     return findalll;
 }
@DeleteMapping("/{id}")
    public ResponseEntity<?> deletebyid(@PathVariable long id){
        service.find(id);
        return new ResponseEntity<>("delete by title",HttpStatus.OK);
}

@PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable long id,@RequestBody PostDto dto){
    PostDto update = service.update(id, dto);
    return new ResponseEntity<>(update,HttpStatus.OK);
}

}
