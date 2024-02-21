package com.blog.Controller;

import com.blog.Service.CommentService;
import com.blog.payload.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private CommentService service;



@PostMapping
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto dto,
                                           @RequestParam long id
){
    CommentDto findall = service.findall(dto, id);
    return new ResponseEntity<>(findall, HttpStatus.OK);
}
@DeleteMapping("/{id}")
    public ResponseEntity<String> Deletecomment(@PathVariable long id){
    service.deleteComment(id);
    return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
}
//new Delete Concept Author nansola
    @DeleteMapping("//{id}")
    public ResponseEntity<String> Delete(@PathVariable long id){
        service.Delete(id);
 return  new ResponseEntity<>("deleted successfully ",HttpStatus.OK);

    }

  @PutMapping
  public ResponseEntity<CommentDto> update(@RequestParam long cid,long pid,@RequestBody CommentDto dto) {
      CommentDto update = service.update(cid, pid,dto);
      return new ResponseEntity<>(update,HttpStatus.UPGRADE_REQUIRED);
  }

}
