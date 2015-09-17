package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jlovas on 9/16/15.
 */
public class HappyMood extends Mood {

    @Override
    public String mood(){
        return "I am happy!";
    }

    public HappyMood(Date date) {
        super(date);
    }

    public HappyMood() {
    }
}
