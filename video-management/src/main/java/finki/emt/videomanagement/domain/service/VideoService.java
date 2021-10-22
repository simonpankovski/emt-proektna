package finki.emt.videomanagement.domain.service;

import finki.emt.videomanagement.domain.models.*;
import finki.emt.videomanagement.domain.valueobjects.UserId;


import java.util.List;
import java.util.Optional;

public interface VideoService {
    Optional<Video> findById(VideoId id);
    Optional<Video> findByName(String name);
    List<Video> getAll();
    void saveVideo(Video video);
    void deleteVideo(VideoId id);
    void addComment(VideoId id, Comment comment);
    void deleteComment(VideoId id, CommentId commentId);
    void addTag(VideoId id, Tag tag);

}
