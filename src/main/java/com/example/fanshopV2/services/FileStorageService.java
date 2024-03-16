package com.example.fanshopV2.services;

import com.example.fanshopV2.entitys.Avatar;
import com.example.fanshopV2.repositories.AvatarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    /*@Autowired*/
    private AvatarRepo avatarRepo;

    public FileStorageService(AvatarRepo avatarRepo) {
        this.avatarRepo = avatarRepo;
    }

    public Avatar store(MultipartFile file) throws IOException  {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Avatar avatar = new Avatar(/*fileName, file.getContentType(), file.getBytes()*/);
        avatar.setName(fileName);
        avatar.setType(file.getContentType());
        /*avatar.setData(file.getBytes());*/
        System.out.println(avatar.getType());
        System.out.println(avatar.getName());
        return avatarRepo.save(avatar);
    }

    public Avatar getFile(String id) {
        return avatarRepo.findById(id).get();
    }

    public Stream<Avatar> getAllFiles() {
        return avatarRepo.findAll().stream();
    }
}

