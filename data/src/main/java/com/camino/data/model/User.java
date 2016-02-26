package com.camino.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by robert on 25.02.16.
 */
public class User {
    @SerializedName("username") private String mUsername;
    @SerializedName("externalId") private String mExternalId;
    @SerializedName("email") private String mEmail;
    //facebook or beatclip
    @SerializedName("accountType") private String mAccountType;
    @SerializedName("userAvatar") private String mUserAvatar;
    @SerializedName("firstname") private String mFirstname;
    @SerializedName("lastname") private String mLastname;
    @SerializedName("company") private String mCompany;
    @SerializedName("website") private String mWebsite;
    @SerializedName("birthday") private Date mBirthday;
    @SerializedName("newsletter") private boolean mNewsletter;
    @SerializedName("verified") private boolean mIsVerified;
    @SerializedName("vip") private boolean mIsVip;
    @SerializedName("videoCount") private int mVideoCount;
    @SerializedName("followerCount") private int mFollowerCount;
    @SerializedName("followingCount") private int mFollowingCount;
    @SerializedName("followedByYou") private boolean mFollowedByYou;
    @SerializedName("male") private Boolean mIsMale;
    @SerializedName("activationCode") private String mPromoCode;
    @SerializedName("fbUserId") private String mFbUserId;
    @SerializedName("fbUserToken") private String mFbUserToken;
    @SerializedName("password") private String mPassword;
    @SerializedName("isLoggedIn") private boolean mIsLoggedIn;

    public String getUsername() {
        return mUsername;
    }

    public String getExternalId() {
        return mExternalId;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getAccountType() {
        return mAccountType;
    }

    public String getUserAvatar() {
        return mUserAvatar;
    }

    public String getFirstname() {
        return mFirstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public Date getBirthday() {
        return mBirthday;
    }

    public boolean isNewsletter() {
        return mNewsletter;
    }

    public boolean isVerified() {
        return mIsVerified;
    }

    public boolean isVip() {
        return mIsVip;
    }

    public int getVideoCount() {
        return mVideoCount;
    }

    public int getFollowerCount() {
        return mFollowerCount;
    }

    public int getFollowingCount() {
        return mFollowingCount;
    }

    public boolean isFollowedByYou() {
        return mFollowedByYou;
    }

    public Boolean getMale() {
        return mIsMale;
    }

    public String getPromoCode() {
        return mPromoCode;
    }

    public String getFbUserId() {
        return mFbUserId;
    }

    public String getFbUserToken() {
        return mFbUserToken;
    }

    public String getPassword() {
        return mPassword;
    }

    public boolean isLoggedIn() {
        return mIsLoggedIn;
    }
}
