package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by jlovas on 9/16/15.
 */
public class ImportantTweet extends Tweet {

    //constructors
    public ImportantTweet(Date date, String tweet) throws IOException{
        //super(date, tweet); //referring to the consructor in the super, in Tweet
        super(date, tweet);
        this.setText(tweet);
        this.date=date;

    }

    public ImportantTweet(String tweet) throws IOException{
        super(tweet);
    }

    public boolean isImportant() {
    return Boolean.TRUE;
    }

    @Override //overrides whether its there or not, but java will watch out for u if u misspell
    public String getText(){
        return "!!!" + super.getText();
    }
}
