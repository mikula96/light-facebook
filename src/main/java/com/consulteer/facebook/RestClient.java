package com.consulteer.facebook;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

    private String server = "http://api.chucknorris.io";
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "*/*");
    }

    public ResponseEntity get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        this.setHttpStatus(responseEntity.getStatusCode());
        return responseEntity;
    }

    public String post(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public String put(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(server + uri, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public void delete(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(server + uri, HttpMethod.DELETE, requestEntity, String.class);
        setHttpStatus(responseEntity.getStatusCode());
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
