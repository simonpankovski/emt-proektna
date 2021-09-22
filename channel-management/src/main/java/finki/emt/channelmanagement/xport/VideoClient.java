package finki.emt.channelmanagement.xport;

import finki.emt.channelmanagement.domain.valueobjects.Video;
import finki.emt.channelmanagement.domain.valueobjects.VideoId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
@Service
public class VideoClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public VideoClient(@Value("${app.video-management.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public Video findVideo(String name) {
        try {
            return restTemplate.exchange(uri().path("/api/users").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<Video>() {
            }).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}