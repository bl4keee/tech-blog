package com.bl4kee.techblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Article")
public class Article {

    @Id
    private String id;
    private String title;
    private String userId;
    private Integer likes;
    private String content;
    private Integer dislikes;
    private Set<String> tags;
    private Integer viewCount;
    private String articleUrl;
    private String description;
    private String thumbnailUrl;
    private MediaStatus articleStatus;
    private List<Comment> commentList;
}
