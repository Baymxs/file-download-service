package com.azoft.filedownloadservice;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/files")
@RequiredArgsConstructor
public class FileDownloadController {
    private final FileDownloadService fileDownloadService;

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> getById(@PathVariable String id) throws IOException {
        FileResponse fileResponse = fileDownloadService.getFileById(id);

        setAttachmentHeader(fileResponse.getInitialFileName());

        return new ResponseEntity<>(fileResponse.getData(), setAttachmentHeader(fileResponse.getInitialFileName()), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<InputStreamResource> getByName(@PathVariable UUID name) throws IOException {
        FileResponse fileResponse = fileDownloadService.getFileByName(name);

        setAttachmentHeader(fileResponse.getInitialFileName());

        return new ResponseEntity<>(fileResponse.getData(), setAttachmentHeader(fileResponse.getInitialFileName()), HttpStatus.OK);
    }

    private HttpHeaders setAttachmentHeader(String fileName) {
        final HttpHeaders headers = new HttpHeaders();

        headers.setContentDispositionFormData("attachment", fileName);

        return headers;
    }
}
