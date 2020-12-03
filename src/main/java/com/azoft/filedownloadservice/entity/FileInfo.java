package com.azoft.filedownloadservice.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "incoming_files")
@Getter
public class FileInfo {
    @Id
    @Column(name = "guid")
    private String id;

    @Column(name = "file_id")
    private UUID name;

    @Column(name = "filename")
    private String initialName;
}
