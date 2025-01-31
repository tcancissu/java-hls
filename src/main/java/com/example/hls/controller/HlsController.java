package com.example.hls.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class HlsController {

    private final String videoDirectory = "src/main/resources/static/videos/";

    @GetMapping("/hls/playlist.m3u8")
    public Resource getPlaylist() throws Exception {
        Path filePath = Paths.get(videoDirectory + "output.m3u8");
        return new UrlResource(filePath.toUri());
    }

    @GetMapping("/hls/{segment}")
    public Resource getSegment(@PathVariable String segment) throws Exception {
        Path filePath = Paths.get(videoDirectory + segment);
        return new UrlResource(filePath.toUri());
    }
}