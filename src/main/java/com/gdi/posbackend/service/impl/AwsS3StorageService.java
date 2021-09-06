package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:53 AM
 */
@Service
@AllArgsConstructor
public class AwsS3StorageService implements StorageService {
    @Override
    public String uploadImageFile(MultipartFile file) {
        return null;
    }
}
