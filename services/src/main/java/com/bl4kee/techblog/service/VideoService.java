package com.bl4kee.techblog.service;

import com.bl4kee.techblog.dto.UploadVideoResponse;
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

    public UploadVideoResponse uploadVideo(MultipartFile file) {
        String videoUrl = s3Service.uploadFile(file);
        Video video = createVideoWithUrl(videoUrl);
        var savedVideo = videoRepository.save(video);

        return new UploadVideoResponse(savedVideo.getId(), savedVideo.getVideoUrl());
    }

    public VideoDTO editVideoMetadata(VideoDTO videoDTO) {
        var savedVideo = getVideoById(videoDTO.getId());
        savedVideo.setTitle(videoDTO.getTitle());
        savedVideo.setDescription(videoDTO.getDescription());
        savedVideo.setTags(videoDTO.getTags());
        savedVideo.setThumbnailUrl(videoDTO.getThumbnailUrl());
        savedVideo.setVideoStatus(videoDTO.getVideoStatus());
        videoRepository.save(savedVideo);

        return videoDTO;
    }


    public String uploadThumbnail(MultipartFile file, String videoId) {
        var savedVideo = getVideoById(videoId);

        String thumbnailUrl = s3Service.uploadFile(file);
        savedVideo.setThumbnailUrl(thumbnailUrl);

        videoRepository.save(savedVideo);
        return thumbnailUrl;
    }

    private Video getVideoById(String videoId) {
        return videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + videoId));
    }

    private Video createVideoWithUrl(String url) {
        var video = new Video();
        video.setVideoUrl(url);
        return video;
    }
}
