package com.azoft.filedownloadservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;

@RequiredArgsConstructor
@Getter
public class FileResponse {
    private final InputStreamResource data;
    private final String initialFileName;
}
