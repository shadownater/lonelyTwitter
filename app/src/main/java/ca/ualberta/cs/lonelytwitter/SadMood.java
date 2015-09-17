package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jlovas on 9/16/15.
 */
public class SadMood extends Mood {

    @Override
    public String mood(){
        return "I am sad!";
    }

    public SadMood(Date date) {
        super(date);
    }

    public SadMood() {
    }
}
