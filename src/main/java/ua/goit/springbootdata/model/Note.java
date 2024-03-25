package ua.goit.springbootdata.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Note {

    private long id;
    private String title;
    private String content;
    public Note() {
        System.out.println("In constructor");
    }
    public void hello() {
        System.out.println("I'm Note");
    }

}
