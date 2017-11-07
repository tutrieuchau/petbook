package com.tutrieuchau.petbook.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tutrieuchau.petbook.Model.DoctorHeader;
import com.tutrieuchau.petbook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tutr on 10/29/2017.
 */

public class DoctorHeaderAdapter extends ArrayAdapter {
    private Context context;

    public DoctorHeaderAdapter(@NonNull Context context,@NonNull ArrayList<DoctorHeader> data) {
        super(context,0, data);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.doctor_list_view_item,parent,false);
        }
        return convertView;
    }
}
