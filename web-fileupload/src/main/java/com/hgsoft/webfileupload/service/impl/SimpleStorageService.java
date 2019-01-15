package com.hgsoft.webfileupload.service.impl;

import com.hgsoft.webfileupload.service.StorageService;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

public class SimpleStorageService implements StorageService {

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
