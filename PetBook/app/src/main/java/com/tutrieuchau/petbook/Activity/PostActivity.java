package com.tutrieuchau.petbook.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.tutrieuchau.petbook.Adapter.PostHeaderAdapter;
import com.tutrieuchau.petbook.Model.PostHeader;
import com.tutrieuchau.petbook.R;
import com.tutrieuchau.petbook.Utils.Utils;

import java.util.ArrayList;

public class PostActivity extends Activity implements View.OnClickListener{
    private ListView postListView;
    private ImageView postButtonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_post);
        postListView = (ListView) findViewById(R.id.postListView);
        postButtonBack = (ImageView) findViewById(R.id.postButtonBack);
        postButtonBack.setOnClickListener(this);
        ArrayList<PostHeader> postHeaders = new ArrayList<>();
        postHeaders.add(new PostHeader(null,null,R.drawable.ic_dog2, Utils.POST_LIST_VIEW_TYPE.HEADER));
        for(int i = 0; i < 10 ; i++){
            postHeaders.add(new PostHeader(null,null,R.drawable.ic_dog2, Utils.POST_LIST_VIEW_TYPE.CONTENT));
        }
        PostHeaderAdapter adapter = new PostHeaderAdapter(this,postHeaders);
        postListView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.postButtonBack:
                //TODO:Test
                Intent intent = new Intent(this,DetailActivity.class);
                startActivity(intent);
//                finish();
                break;
        }
    }
}
