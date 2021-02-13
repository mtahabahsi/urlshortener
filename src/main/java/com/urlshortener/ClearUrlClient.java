package com.urlshortener;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("/url")
public interface ClearUrlClient {
    @Get("/urlApi")
    String url(String clear_url);
}