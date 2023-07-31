package com.mahmoudadany.facebookv1.data;

import com.mahmoudadany.facebookv1.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<PostModel>> getPost();

}
