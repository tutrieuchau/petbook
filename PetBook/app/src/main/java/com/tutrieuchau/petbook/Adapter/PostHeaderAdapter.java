package com.tutrieuchau.petbook.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tutrieuchau.petbook.Model.PostHeader;
import com.tutrieuchau.petbook.R;
import com.tutrieuchau.petbook.Utils.Utils;

import java.util.ArrayList;

/**
 * Created by tutr on 10/28/2017.
 */

public class PostHeaderAdapter extends ArrayAdapter {
    private Context context;

    public PostHeaderAdapter(@NonNull Context context, @NonNull ArrayList<PostHeader> data) {
        super(context, 0, data);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PostHeader postHeader = (PostHeader) getItem(position);
        if(postHeader.postType == Utils.POST_LIST_VIEW_TYPE.HEADER){
            convertView = LayoutInflater.from(context).inflate(R.layout.post_list_view_item_header,parent,false);
        }else{
            convertView = LayoutInflater.from(context).inflate(R.layout.post_list_view_item_content,parent,false);
        }
        return convertView;
    }
}
