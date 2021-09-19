package com.bl4kee.techblog.service;

import com.bl4kee.techblog.dto.VideoDTO;
import com.bl4kee.techblog.model.Video;
import com.bl4kee.techblog.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile file) {
        String videoUrl = s3Service.uploadFile(file);
        Video video = createVideoWithUrl(videoUrl);

        videoRepository.save(video);
    }

    public VideoDTO editVideoMetadata(VideoDTO videoDTO) {
        Video savedVideo = videoRepository.findById(videoDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + videoDTO.getId()));

        savedVideo.setTitle(videoDTO.getTitle());
        savedVideo.setDescription(videoDTO.getDescription());
        savedVideo.setTags(videoDTO.getTags());
        savedVideo.setThumbnailUrl(videoDTO.getThumbnailUrl());
        savedVideo.setVideoStatus(videoDTO.getVideoStatus());
        videoRepository.save(savedVideo);

        return videoDTO;
    }

    private Video createVideoWithUrl(String url) {
        var video = new Video();
        video.setVideoUrl(url);
        return video;
    }
}
