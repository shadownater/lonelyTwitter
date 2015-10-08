package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by romansky on 9/30/15.
 */
public class TweetList implements MyObservable {
    private ArrayList<MyObserver> myObservers = new ArrayList<MyObserver>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
        notifyObservers();
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    //will add to the list
    public void addObserver(MyObserver o) {
        myObservers.add(o);
    }

    public void notifyObservers() {
        for(MyObserver observer: myObservers){
            observer.myNotify();
        }
    }
}
