package com.hgsoft.webfileupload.service;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 存储服务接口
 */
public interface StorageService {
    //初始化
    void init();
    //存储
    void store(MultipartFile file);
    //加载文件
    Stream<Path> loadAll();
    //加载文件路径
    Path load(String filename);
    //加载资源文件
    Resource loadAsResource(String filename);
    //删除全部
    void deleteAll();

}
