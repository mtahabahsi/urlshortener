package com.urlshortener;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("/url")
public class ClearUrlClient {
    private ClearUrlApi api;

    @Get("/url")
    public String url(String url){
        String clear_url = api.get_clear_url(url);
        System.out.println(clear_url);



    return clear_url;
    }
}