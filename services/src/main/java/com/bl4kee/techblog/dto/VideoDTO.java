package com.bl4kee.techblog.dto;

import com.bl4kee.techblog.model.MediaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {

    private String id;
    private String title;
    private String videoUrl;
    private Set<String> tags;
    private String description;
    private String thumbnailUrl;
    private MediaStatus videoStatus;
}
