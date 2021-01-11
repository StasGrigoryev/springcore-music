package org.example.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Computer {
    private int id;
    private MusicPlayer mp;

    @Autowired
    public Computer(MusicPlayer mp) {
        id = 1;
        this.mp = mp;
    }

    public MusicPlayer getMp() {
        return mp;
    }

    public void setMp(MusicPlayer mp) {
        this.mp = mp;
    }

    public void boot() {
        String input = "";
        while(true) {
            try {
                System.out.println("Enter a genre");
                input = MusicHelper.getUserInput();
                mp.playMusic(Genre.valueOf(input.toUpperCase(Locale.ENGLISH)));
            } catch (IllegalArgumentException e) {
                System.out.println("No such genre");
                boot();
            }
            break;
        }
        MusicHelper.closeReader();
    }
}
