package com.swift.json;

public class Obj {
	String fileMetaData;
	long fileSize; 
	String lastModified;
	
	public String getFileMetaData() {
		return fileMetaData;
	}

	public void setFileMetaData(String fileMetaData) {
		this.fileMetaData = fileMetaData;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public Obj() {
	}
	
	public Obj(String fileMetaData,long filesize,String lastModified){
		setFileMetaData(fileMetaData);
		setFileSize(filesize);
		setLastModified(lastModified);
	}
}
