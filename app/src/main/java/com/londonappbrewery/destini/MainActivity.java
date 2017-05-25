package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;

    StoryNode mT1Node, mT2Node, mT3Node;
    StoryNode mT4End, mT5End, mT6End;

    StoryNode mActualNode;

    boolean mGameEnded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mT1Node = new StoryNode(R.string.T1_Story, false);
        mT2Node = new StoryNode(R.string.T2_Story, false);
        mT3Node = new StoryNode(R.string.T3_Story, false);

        mT4End = new StoryNode(R.string.T4_End, true);
        mT5End = new StoryNode(R.string.T5_End, true);
        mT6End = new StoryNode(R.string.T6_End, true);

        mT1Node.setStory(R.string.T1_Ans1, mT3Node, R.string.T1_Ans2, mT2Node);
        mT2Node.setStory(R.string.T2_Ans1, mT3Node, R.string.T2_Ans2, mT4End);
        mT3Node.setStory(R.string.T3_Ans1, mT6End, R.string.T3_Ans2, mT5End);

        mActualNode = mT1Node;

        mGameEnded = false;


        // Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mGameEnded) {
                    doChoice(true);
                } else {
                    finish();
                }
            }
        });

        // Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doChoice(false);
            }
        });
    }

    private void doChoice(boolean choice) {
        if(choice) {
            mActualNode = mActualNode.getOptionTopLink();
        } else {
            mActualNode = mActualNode.getOptionBottomLink();
        }

        // Update UI
        mStoryTextView.setText(mActualNode.getStoryText());

        // If the chosen history node is not an end story, update both buttons
        if(!mActualNode.isEnd())
        {
            mButtonTop.setText(mActualNode.getOptionTop());
            mButtonBottom.setText(mActualNode.getOptionBottom());
        } else { // else, remove the bottom button and set its text to "Close App"
            mButtonTop.setText(R.string.button_quit);
            mButtonBottom.setVisibility(View.GONE);
            mGameEnded = true;
        }
    }
}
