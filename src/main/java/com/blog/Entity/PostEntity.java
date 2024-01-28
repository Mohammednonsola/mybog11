package com.blog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String content;
    private String Title;
    @OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL)
    private List<Comments> comments;

}
