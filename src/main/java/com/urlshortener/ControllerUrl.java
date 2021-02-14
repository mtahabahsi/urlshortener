package com.urlshortener;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/url")
public class ControllerUrl  {

    @Inject
    private ClearUrlApi api;

    @Get("/url")
    public String url(String url) {
        System.out.println("controllerurl.java sayfasında url methodu");
        url = api.get_clear_url(url);
        return url;
    }

    @Post(value = "/urlApi", consumes = MediaType.TEXT_PLAIN)
    public String setClearUrl(@Body String url) {
        api.get_clear_url(url);
        return url;
    }
}