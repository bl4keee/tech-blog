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
@Document(value = "Video")
public class Video {

    @Id
    private String id;
    private String title;
    private String userId;
    private Integer likes;
    private String videoUrl;
    private Integer dislikes;
    private Set<String> tags;
    private Integer viewCount;
    private String description;
    private String thumbnailUrl;
    private MediaStatus videoStatus;
    private List<Comment> commentList;
}
