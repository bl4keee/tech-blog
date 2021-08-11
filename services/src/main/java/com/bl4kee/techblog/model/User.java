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
@Document(value = "User")
public class User {

    @Id
    private String id;
    private String lastName;
    private String fullName;
    private String firstName;
    private String emailAddress;

    private Set<String> likedVideos;
    private Set<String> disLikedVideos;
    private List<String> videoHistory;

    private Set<String> likedArticles;
    private Set<String> disLikedArticles;
    private List<String> articleHistory;

    private Set<String> subscribers; // users that given user entity subscribes to
    private Set<String> subscribedToUsers; // users that subscribe to the given user entity
}
