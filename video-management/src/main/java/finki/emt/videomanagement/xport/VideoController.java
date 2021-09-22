package finki.emt.videomanagement.xport;

import finki.emt.videomanagement.domain.models.*;
import finki.emt.videomanagement.domain.repository.TagRepository;
import finki.emt.videomanagement.domain.repository.VideoTagsRepository;
import finki.emt.videomanagement.domain.service.StorageService;
import finki.emt.videomanagement.domain.service.impl.VideoServiceImpl;
import finki.emt.videomanagement.domain.valueobjects.VideoName;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    private final StorageService storageService;
    private final TagRepository tagRepository;
    private final VideoTagsRepository videoTagsRepository;

    private final VideoServiceImpl videoService;

    public VideoController(StorageService storageService, TagRepository tagRepository, VideoTagsRepository videoTagsRepository, VideoServiceImpl videoService) {
        this.storageService = storageService;
        this.tagRepository = tagRepository;
        this.videoTagsRepository = videoTagsRepository;
        this.videoService = videoService;
    }
    @GetMapping("/video/{id}")
    public Video getVideo(@PathVariable VideoId id){
        Optional<Video> video = videoService.findById(id);
        return video.orElse(null);
    }
    @PostMapping("/tag/{tag}/video/{id}")
    public List<TagVideos> setTag(@PathVariable TagId tag, @PathVariable VideoId id){
        Optional<Video> video = videoService.findById(id);
        Video temp = video.get();
        Optional<Tag> t = tagRepository.findById(tag);
        Tag tem = t.get();
        temp.addTag(tem);
        videoService.saveVideo(temp);
        return videoTagsRepository.findAllByTagId(tag);
    }
    @PostMapping("/tag")
    public void saveTag(@RequestBody String name){
        Tag t = new Tag(name);
        tagRepository.save(t);
    }
    @GetMapping(value = "/files",produces = "video/mp4")
    @ResponseBody
    public FileSystemResource serveFile(@RequestParam String name) {
        Optional<Video> video = videoService.findByName(name);
        if(video.isPresent()){
            Path file = storageService.load(video.get().getLocation());
            return new FileSystemResource(new File(String.valueOf(file)));
        }
        return null;

    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam String video) throws IOException {
        if(videoService.findByName(video).isEmpty()) {
            Video video1 = new Video(video);
            String res = storageService.store(file, video1.getName());
            video1.setLocation(res);
            videoService.saveVideo(video1);
            return res;
        }




        return "Video exists";

    }


}