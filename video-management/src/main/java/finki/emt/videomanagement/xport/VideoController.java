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
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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

    @GetMapping("/videos")
    public List<String> getVideos(){

        List<Video> videos = videoService.getAll();
        List<String> paths = new ArrayList<>();
        for (Video video:videos
             ) {
            paths.add(video.getName());

        }

        return paths;
    }
    @PostMapping("/tag/{tag}/video/{name}")
    public List<TagVideos> setTag(@PathVariable String tag, @PathVariable String name){
        Optional<Video> video = videoService.findByName(name);
        Video temp = video.get();
        Optional<Tag> t = tagRepository.findByName(tag);
        Tag tem = t.get();
        temp.addTag(tem);
        videoService.saveVideo(temp);
        return videoTagsRepository.findAllByTagName(tag);
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
    public RedirectView handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String video = request.getParameter("video");
        RedirectView redirectView = new RedirectView();
        if(videoService.findByName(video).isEmpty()) {
            Video video1 = new Video(video);
            String res = storageService.store(file, video1.getName());
            video1.setLocation(res);
            videoService.saveVideo(video1);
            redirectView.setUrl("http://localhost:3000/");
            return redirectView;
        }
        redirectView.setUrl("http://localhost:3000/new");
        return redirectView;

    }


}