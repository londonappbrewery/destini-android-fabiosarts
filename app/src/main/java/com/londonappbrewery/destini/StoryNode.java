package com.londonappbrewery.destini;

/**
 * Created by Fabian on 25/5/2017.
 */

public class StoryNode {
    private int mStoryText;

    private int mOptionTop;
    private StoryNode mOptionTopLink;
    private int mOptionBottom;
    private StoryNode mOptionBottomLink;
    private boolean mIsEnd;

    public StoryNode(int storyText, boolean isEnd) {
        mStoryText = storyText;
        mIsEnd = isEnd;
    }

    public void setStory(int optionTop, StoryNode optionTopLink, int optionBottom, StoryNode optionBottomLink) {
        mOptionTop = optionTop;
        mOptionTopLink = optionTopLink;
        mOptionBottom = optionBottom;
        mOptionBottomLink = optionBottomLink;
    }

    public int getStoryText() {
        return mStoryText;
    }

    public int getOptionTop() {
        return mOptionTop;
    }

    public StoryNode getOptionTopLink() {
        return mOptionTopLink;
    }

    public int getOptionBottom() {
        return mOptionBottom;
    }

    public StoryNode getOptionBottomLink() {
        return mOptionBottomLink;
    }

    public boolean isEnd() {
        return mIsEnd;
    }
}
