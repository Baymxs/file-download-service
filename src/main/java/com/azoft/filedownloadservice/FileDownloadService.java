package com.azoft.filedownloadservice;

import com.azoft.filedownloadservice.entity.FileInfo;
import com.azoft.filedownloadservice.exception.ResourceNotFoundException;
import com.azoft.filedownloadservice.repository.FileInfoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDownloadService {
    private final FileInfoRepository fileInfoRepository;

    @Value("${filepath}")
    private String filePath;

    public FileResponse getFileById(String id) throws IOException {
        final FileInfo fileInfo = fileInfoRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("File with id [" + id + "] not found"));

        return new FileResponse(new InputStreamResource(new Base64InputStream(new FileInputStream(filePath + fileInfo.getName()))), fileInfo.getInitialName());
    }

    public FileResponse getFileByName(UUID name) throws IOException {
        final FileInfo fileInfo = fileInfoRepository.
                findByName(name).
                orElseThrow(() -> new ResourceNotFoundException("File with name [" + name + "] not found"));

        return new FileResponse(new InputStreamResource(new FileInputStream(filePath + fileInfo.getName())), fileInfo.getInitialName());
    }
}
