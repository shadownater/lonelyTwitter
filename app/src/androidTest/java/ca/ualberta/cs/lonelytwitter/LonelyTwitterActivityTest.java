package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {
    private Button saveButton;
    private EditText bodyText;
    private EditText editTweetField;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }


    public void testEditTweet(){
        //when you call getactivity android will start the app and the activity
        LonelyTwitterActivity activity = (LonelyTwitterActivity)getActivity();

        //reset the app to a known state so we know what it's starting with
        activity.getTweets().clear();

        //add a tweet using the UI
        bodyText = activity.getBodyText();
        activity.runOnUiThread(new Runnable() {

            public void run() {
                bodyText.setText("test tweet");
            }
        });
        getInstrumentation().waitForIdleSync(); //wait for thread to finish

        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();


        //make sure the tweet was actually stored
        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet =(Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("test tweet", tweet.getText());




        //ensure the tweet editor activity starts up

        //The following is from: https://developer.android.com/training/activity-testing/activity-functional-testing.html, Oct 14, 15

        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);
        //the code where they clicked was here - so heres mine

        //click on the tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0,v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();

        // Validate that ReceiverActivity is started
        final EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //test that the editor starts up with the right tweet in it to edit
        //just opened the activity from above
        //is that the tweet we clicked?
        editTweetField = receiverActivity.getEditTweetField();
        //make sure editTweetActivity gets tweet selected from the original
        receiverActivity.runOnUiThread(new Runnable() {
            public void run() {
                //want to grab what is clicked? How?
                receiverActivity.getEditTweetField();
            }
        });
        getInstrumentation().waitForIdleSync();



        //test that we can edit that tweet

        //test that we can push some kind of save button for that tweet

        //the new modified tweet text was actually saved

        //the new modified tweet text is displayed on the other activity


        //clean up our activities at the end of our test
        receiverActivity.finish();
    }

}