package com.blog.Repository;

import com.blog.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {

}
