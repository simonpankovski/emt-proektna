package finki.emt.videomanagement.xport;

import finki.emt.videomanagement.domain.valueobjects.User;
import finki.emt.videomanagement.domain.valueobjects.UserId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class UserClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public UserClient(@Value("${app.channel-management.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public User findUser(UserId id) {
        try {
            return restTemplate.exchange(uri().path("/api/users").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<User>() {
            }).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}

