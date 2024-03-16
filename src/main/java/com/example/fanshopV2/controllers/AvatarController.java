package com.example.fanshopV2.controllers;

import com.example.fanshopV2.entitys.Avatar;
import com.example.fanshopV2.entitys.Message;
import com.example.fanshopV2.repositories.AvatarRepo;
import com.example.fanshopV2.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.util.stream.Collectors;

@Controller
public class AvatarController {

   /* @Autowired
    private Avatar avatar;*/

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private AvatarRepo avatarRepo;

   /* public AvatarController(Avatar avatar) {
        this.avatar = avatar;
    } */

    @GetMapping("addAvatar")
    public String avatar(Model model) {
        Iterable<Avatar> avatars = avatarRepo.findAll();
        model.addAttribute("avatars", avatars);
        return "/main";
    }

    @PostMapping("addAvatar")
    public String addAvatar(@RequestParam("avatar") MultipartFile avatar, Model model) {
        try {
            storageService.store(avatar);
        } catch (Exception e) {
            System.out.println("Erorr");
        }
        Iterable<Avatar> avatars = avatarRepo.findAll();
        model.addAttribute("avatars", avatars);
        return "/main";
    }


 /*   @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Avatar avatar1 = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + avatar1.getName() + "\"")
                .body(avatar1.getData());
    } */


}
