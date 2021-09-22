package finki.emt.videomanagement.domain.service.impl;

import finki.emt.videomanagement.domain.exceptions.VideoNotFoundException;
import finki.emt.videomanagement.domain.models.*;
import finki.emt.videomanagement.domain.repository.VideoRepository;
import finki.emt.videomanagement.domain.service.VideoService;
import finki.emt.videomanagement.domain.valueobjects.UserId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    @Override
    public Optional<Video> findById(VideoId id) {
        return videoRepository.findById(id);
    }

    @Override
    public Optional<Video> findByName(String name) {
        return videoRepository.findVideoByName(name);
    }

    @Override
    public void saveVideo(Video video) {
        videoRepository.saveAndFlush(video);
    }

    @Override
    public void deleteVideo(VideoId id) {
        videoRepository.deleteById(id);
    }

    @Override
    public void addComment(VideoId id, Comment comment) throws VideoNotFoundException {
        Video video = videoRepository.findById(id).orElseThrow(VideoNotFoundException::new);
        video.addComment(comment);
        videoRepository.saveAndFlush(video);
    }

    @Override
    public void deleteComment(VideoId id, CommentId commentId) {
        Video video = videoRepository.findById(id).orElseThrow(VideoNotFoundException::new);
        video.removeComment(commentId);
        videoRepository.saveAndFlush(video);
    }

    @Override
    public void addTag(VideoId id, Tag tag) {
        Video video = videoRepository.findById(id).orElseThrow(VideoNotFoundException::new);
        video.addTag(tag);
        videoRepository.saveAndFlush(video);
    }


}
