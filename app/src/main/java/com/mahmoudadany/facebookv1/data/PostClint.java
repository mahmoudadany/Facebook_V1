package com.mahmoudadany.facebookv1.data;

import com.mahmoudadany.facebookv1.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClint {
    private final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static PostClint instance=null;
    private PostInterface postInterface;

    private PostClint(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface=retrofit.create(PostInterface.class);
    }

    public synchronized static PostClint getInstance(){
        if(instance==null){
            instance=new PostClint();
        }
        return instance;
    }

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPost();
    }

}
