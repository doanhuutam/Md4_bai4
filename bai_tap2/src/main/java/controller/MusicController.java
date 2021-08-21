package controller;

import model.FormMusic;
import model.Music;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.MusicService;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Value("{upload}")
    private String upload;
    private final MusicService musicService = new MusicService();

    @GetMapping("/home")
    public ModelAndView show() {
        ModelAndView modelAndView=new ModelAndView("/show");
        modelAndView.addObject("list",musicService.list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showcreate(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("list",new FormMusic());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("list") FormMusic music){
        MultipartFile multipartFile=music.getLink();
//        lay ra ten file duoc up
        String file=multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(music.getLink().getBytes(),new File("/Users/tam/IdeaProjects/Bai4_md4/bai_tap2/src/main/webapp"+file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music1=new Music(music.getName(),music.getSinger(),music.getType(),file);
        musicService.save(music1);
        ModelAndView modelAndView=new ModelAndView("/create");
                modelAndView.addObject("list",music);
                modelAndView.addObject("message","tao thanh cong!");
                return modelAndView;
    }

}
