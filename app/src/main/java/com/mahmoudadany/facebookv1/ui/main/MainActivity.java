package com.mahmoudadany.facebookv1.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mahmoudadany.facebookv1.R;
import com.mahmoudadany.facebookv1.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public PostViewModel viewModel;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerview);
        viewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        viewModel.getPosts();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

         viewModel.liveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> list) {
                PostAdapter adapter=new PostAdapter(list);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}