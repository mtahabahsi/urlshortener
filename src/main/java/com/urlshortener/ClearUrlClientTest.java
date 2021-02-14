package com.urlshortener;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClearUrlClientTest {
    private EmbeddedServer server;
    private ClearUrlClient client;

    @Before
    public void setup() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().getBean(ClearUrlClient.class);
    }

    @After
    public void cleanup() {
        server.stop();
    }

    @Test
    public void test_clear_api() {
        System.out.println("test yapma sayfası");
        assertEquals(client.url("https%3A%2F%2Fgoogle.com%2F"), "https:\\/\\/cleanuri.com\\/pEqXje");
    }
}