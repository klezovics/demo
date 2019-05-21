package com.klezovich.demo.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeformService {

    private final TypeformSettings settings;

    private final RestTemplate rest = new RestTemplate();

    public List<String> getSurveys() {
        return List.of();
    }

    public String getMyEmail() {

        var response = get(getBaseUrl()+"me").getBody();
        var map = new JacksonJsonParser().parseMap(response);
        return (String) map.get("email");
    }

    private HttpEntity<String> getAuthHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(getAccessToken());

        return new HttpEntity<>(headers);
    }

    private ResponseEntity<String> get(String url) {
        return rest.exchange(url, HttpMethod.GET, getAuthHeaders(), String.class);
    }

    private String getAccessToken() {
        return settings.getToken();
    }

    private String getBaseUrl() {
        return settings.getBaseUrl();
    }


}
