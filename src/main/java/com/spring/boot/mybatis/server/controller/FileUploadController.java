package com.spring.boot.mybatis.server.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther xuxq
 * @date 2018/12/31 16:39
 */
@RestController
@RequestMapping("/uploads")
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping
    public String index(){
        return "index.html";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public Map<String,String> upload1(@RequestParam("file")MultipartFile file) throws IOException {
        log.info("[文件类型] - [{}]",file.getContentType());
        log.info("[文件名称] - [{}]",file.getOriginalFilename());
        log.info("[文件大小] - [{}]",file.getSize());

        file.transferTo(new File("D:\\file\\" + file.getOriginalFilename()));
        Map<String,String> map = new HashMap<>(16);
        map.put("contentType",file.getContentType());
        map.put("fileName",file.getOriginalFilename());
        map.put("fileSize",file.getSize() + "");
        return map;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String,String>> upload2(@RequestParam("file")MultipartFile[] files) throws IOException {
        if ((files == null)||(files.length == 0)){
            return null;
        }
        List<Map<String,String>> list = new ArrayList<>();
        for (MultipartFile file: files) {
            Map<String,String> map = new HashMap<>(16);
            file.transferTo(new File("D:\\file\\" + file.getOriginalFilename()));
            map.put("contentType",file.getContentType());
            map.put("fileName",file.getOriginalFilename());
            map.put("fileSize",file.getSize() + "");
            list.add(map);
        }
        return list;
    }

    @PostMapping("/upload3")
    @ResponseBody
    public void upload3(String based64) throws IOException {
        final File tempFile = new File("D:\\file\\test.jpg");
        String[] split = based64.split("based64,");
        final byte[] bytes = Base64Utils.decodeFromString(split.length > 1 ? split[1] : split[0]);
        FileCopyUtils.copy(bytes,tempFile);
    }

 }
