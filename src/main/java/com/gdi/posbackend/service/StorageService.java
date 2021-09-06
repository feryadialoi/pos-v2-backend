package com.gdi.posbackend.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:53 AM
 */
public interface StorageService {
    String uploadImageFile(MultipartFile file);
}
