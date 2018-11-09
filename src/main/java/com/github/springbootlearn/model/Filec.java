package com.github.springbootlearn.model;

import java.util.List;

public class Filec {

    private String fileName;
    private String filePath;
    private long fileSize;
    private String fileType;

    private List<Filec> childFiles;

    public Filec(){}

    public Filec(String fileName, String filePath, long fileSize, List<Filec> childFiles) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.childFiles = childFiles;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public List<Filec> getChildFiles() {
        return childFiles;
    }

    public void setChildFiles(List<Filec> childFiles) {
        this.childFiles = childFiles;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
