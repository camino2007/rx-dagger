package com.camino.data;

import com.camino.data.model.BeatClip;
import com.camino.data.model.News;
import com.camino.data.model.User;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by robert on 25.02.16.
 */
public interface AccountApiService {

    @GET("accounts/me/")
    Observable<User> getMe(@Header("Authorization") String authorization);

    @GET("accounts/{externalId}")
    Observable<User> getSingleUser(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @GET("accounts")
    Observable<List<User>> getLatestUsers(@Header("Authorization") String authorization);

    @GET("accounts;offsetId={offsetId}")
    Observable<List<User>> getLatestUsersWithOffset(@Header("Authorization") String authorization, @Path("offsetId") String offsetId);

    @GET("accounts/me/feed")
    Observable<List<BeatClip>> getMyFeed(@Header("Authorization") String authorization);

    @GET("accounts/me/feed;offsetId={offsetId}")
    Observable<List<BeatClip>> getMyFeedWithOffset(@Header("Authorization") String authorization, @Path("offsetId") String offsetId);

    @GET("accounts")
    Observable<List<User>> searchUsers(@Header("Authorization") String authorization, @Query("username") String username);

    @GET("accounts;offsetId={offsetId}")
    Observable<List<User>> searchUsersWithOffset(@Header("Authorization") String authorization, @Query("username") String username, @Path("offsetId") String offsetId);

    @GET("accounts/facebook/{token}")
    void getFacebookUser(@Path("token") String token, Callback<User> rcb);

    @POST("accounts/resetpw;username={username}")
    Observable<Response> resetPw(@Path("username") String username);

    @GET("accounts/me/news")
    Observable<List<News>> getMyNews(@Header("Authorization") String authorization);

    @GET("accounts/me/news;offsetId={offsetId}")
    Observable<List<News>> getMyNewsWithOffset(@Header("Authorization") String authorization, @Path("offsetId") String offsetId);

    @DELETE("accounts/me/news/{externalId}")
    Observable<Response> deleteNews(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @GET("accounts/validateUsername;username={username}")
    Observable<Response> validateUsername(@Path("username") String username);

    @GET("accounts/validateEmail;email={email}")
    Observable<Response> validateEmail(@Path("email") String email);

    @Multipart
    @POST("accounts/")
    Observable<User> createUser(@Part("avatar") RequestBody avatar, @Part("AccountInfo") User toCreate);

    @Multipart
    @PUT("accounts/me/")
    Observable<User> updateMe(@Header("Authorization") String authorization, @Part("avatar") RequestBody avatar, @Part("AccountInfo") User me);

    @PUT("accounts/{externalId}/follow")
    Observable<User> followUser(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @DELETE("accounts/{externalId}/follow")
    Observable<User> unfollowUser(@Header("Authorization") String authorization, @Path("externalId") String externalId);


}
