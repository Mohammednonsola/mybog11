package com.blog.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
