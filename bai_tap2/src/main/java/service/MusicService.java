package service;

import model.Music;

import java.util.ArrayList;

public class MusicService {
    public ArrayList<Music> list=new ArrayList<>();

    public MusicService() {
    }
    public void save(Music music){
        list.add(music);
    }
}
