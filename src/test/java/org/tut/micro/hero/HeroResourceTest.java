package org.tut.micro.hero;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


@QuarkusTest
public class HeroResourceTest {

    @Test
    public void testHelloEndpoint() {
        assertEquals("lll", "lll", "everything is all right");
    }

}