package com.bl4kee.techblog.repository;

import com.bl4kee.techblog.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
