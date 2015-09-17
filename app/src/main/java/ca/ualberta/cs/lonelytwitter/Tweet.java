package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jlovas on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable{
    private String text; //only accessible by the current class, these are acalled ATTRIBUTES
    protected Date date;


    //**** part for the lab assignment ****
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();




    public Tweet(Date date, String tweet) throws IOException { //constructor
        this.date = date;
        this.text = tweet;
    }

    public Tweet(String tweet) throws IOException { //constructor
        this.date = new Date(); //will grab the current date
        this.setText(tweet);
    }


    //getters and setters

    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException { //tells it we might throw an exception

            if (text.length() <= 140) {
                this.text = text;
            } else {
                throw new IOException("Tweet was too long!");
            }

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract boolean isImportant(); //wait until the user picks important or normal tweet when new

}
