package com.camino.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by robert on 25.02.16.
 */
public class BeatClip {

    @SerializedName("externalId") private String mExternalId;
    @SerializedName("title") private String mBeatClipTitle;
    @SerializedName("songTitle") private String mSongTitle;
    @SerializedName("songArtist") private String mSongArtist;
    @SerializedName("songGenre") private String mSongGenre;
    @SerializedName("songAlbum") private String mSongAlbum;
    @SerializedName("duration") private int mDuration;
    @SerializedName("width") private int mWidth;
    @SerializedName("height") private int mHeight;
    @SerializedName("uploadDate") private Date mUploadDate;
    @SerializedName("creationDate") private Date mCreationDate;
    @SerializedName("username") private String mUsername;
    @SerializedName("avatarUrl") private String mAvatarUrl;
    @SerializedName("externalUserId") private String mExternalUserId;
    @SerializedName("userVerified") private boolean mIsUserVerified;
    @SerializedName("publicVideo") private boolean mIsPublicVideo;
    @SerializedName("featured") private boolean mIsFeatured;
    @SerializedName("videoUrl") private String mVideoUrl;
    @SerializedName("previewUrl") private String mPreviewUrl;
    @SerializedName("streamingUrl") private String mStreamingUrl;
    @SerializedName("likes") private int mLikes;
    @SerializedName("likedByMe") private boolean mIsLikedByMe;
    @SerializedName("tutorial") private boolean mIsTutorial;
    @SerializedName("state") private int mState;

    public String getExternalId() {
        return mExternalId;
    }

    public String getBeatClipTitle() {
        return mBeatClipTitle;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongGenre() {
        return mSongGenre;
    }

    public String getSongAlbum() {
        return mSongAlbum;
    }

    public int getDuration() {
        return mDuration;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public Date getUploadDate() {
        return mUploadDate;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getExternalUserId() {
        return mExternalUserId;
    }

    public boolean isUserVerified() {
        return mIsUserVerified;
    }

    public boolean isPublicVideo() {
        return mIsPublicVideo;
    }

    public boolean isFeatured() {
        return mIsFeatured;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public String getPreviewUrl() {
        return mPreviewUrl;
    }

    public String getStreamingUrl() {
        return mStreamingUrl;
    }

    public int getLikes() {
        return mLikes;
    }

    public boolean isLikedByMe() {
        return mIsLikedByMe;
    }

    public boolean isTutorial() {
        return mIsTutorial;
    }

    public int getState() {
        return mState;
    }
}
