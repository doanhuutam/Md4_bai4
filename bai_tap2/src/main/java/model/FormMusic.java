package model;

import org.springframework.web.multipart.MultipartFile;

public class FormMusic {
private String name;
public String singer;
private String type;
private MultipartFile link;

    public FormMusic() {
    }

    public FormMusic(String name, String singer, String type, MultipartFile link) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
