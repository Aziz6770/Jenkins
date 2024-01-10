package org.example.jenkins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CalculatorControllerTest {

    @Test
    void add() throws IOException, InterruptedException {
        int a = 10;
        int b = 5;

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create("http://localhost:8081/add?a=%d&b=%d".formatted(a, b)))
                .GET()
                .build();

        String body = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString())
                .body();

        int answer = Integer.parseInt(body);

        Assertions.assertEquals((a + b), answer);

    }

    @Test
    void subtract() throws IOException, InterruptedException {
        int a = 10;
        int b = 5;

        System.out.println("Hello");

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create("http://localhost:8081/subtract?a=%d&b=%d".formatted(a, b)))
                .GET()
                .build();

        String body = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString())
                .body();

        int answer = Integer.parseInt(body);

        Assertions.assertEquals((a - b), answer);

    }
}