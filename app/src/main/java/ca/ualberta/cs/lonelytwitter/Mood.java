package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jlovas on 9/16/15.
 */
public abstract class Mood {
    //represents the current mood
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Mood(){
        this.date = new Date();
    }

    public abstract String mood();


}
