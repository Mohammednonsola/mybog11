package com.blog.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;
    private  String text;
    private String email;
    @ManyToOne
    @JoinColumn(name = "Post_id")
    private PostEntity postEntity;
}
