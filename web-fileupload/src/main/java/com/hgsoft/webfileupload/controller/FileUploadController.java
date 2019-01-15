package com.hgsoft.webfileupload.controller;

import com.hgsoft.webfileupload.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    @Autowired
    private  StorageService storageService;

    public String listUploadedFiles(Model model){
        model.addAttribute("files",storageService.loadAll().map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"serveFile" ,Collectors.toList())));
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message","you successfully upload "+file.getOriginalFilename()+"!");
        return "redirect:/";

    }
}
