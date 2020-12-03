package com.azoft.filedownloadservice.repository;

import com.azoft.filedownloadservice.entity.FileInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileInfoRepository extends CrudRepository<FileInfo, String> {
    Optional<FileInfo> findByName(UUID name);
}
