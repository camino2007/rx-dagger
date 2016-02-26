package com.camino.data.api;

import com.camino.data.model.BeatClip;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by robert on 26.02.16.
 */
public interface BeatClipApiService {

    @GET("/beatclips/createdby/{externalId}")
    Observable<List<BeatClip>> getBeatclipsForUser(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @GET("/beatclips/howto?platform=android")
    Observable<BeatClip> getHowTo();

    @GET("/beatclips/{externalId}")
    Observable<BeatClip> getBeatClipById(@Path("externalId") String externalId);

    @GET("/beatclips/latest/")
    Observable<List<BeatClip>> getLatestBeatclips(@Header("Authorization") String authorization);

    @GET("/beatclips/latest;offsetId={offsetId}")
    Observable<List<BeatClip>> getLatestBeatclipsWithOffset(@Header("Authorization") String authorization, @Path("offsetId") String offsetId);

    @PUT("/beatclips/{externalId}/like")
    Observable<BeatClip> likeClip(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @DELETE("/beatclips/{externalId}/like")
    Observable<BeatClip> unlikeClip(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @POST("/beatclips/")
    Observable<BeatClip> createBeatclip(@Header("Authorization") String authorization, @Body BeatClip beatClip);

    @PUT("/beatclips/{externalId}")
    Observable<BeatClip> editBeatclip(@Header("Authorization") String authorization, @Path("externalId") String externalId, @Body BeatClip clip);

    @DELETE("/beatclips/{externalId}")
    Observable<Response> deleteBeatclip(@Header("Authorization") String authorization, @Path("externalId") String externalId);

    @Headers({"Content-type: video/mp4"})
    @POST("/beatclips/{externalId};reencode=false")
    Observable<Response> uploadBeatclip(@Header("Authorization") String authorization, @Path("externalId") String externalId, @Body RequestBody beatclip);

/*
    @POST("/beatclips/{externalId}/share")
    Observable<Response> shareClipOnServer(@Header("Authorization") String authorization, @Path("externalId") String externalId, @Body ClipToShareItem clipToShareItem);
*/

}
