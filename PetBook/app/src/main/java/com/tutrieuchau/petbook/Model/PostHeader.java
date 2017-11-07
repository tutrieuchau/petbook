package com.tutrieuchau.petbook.Model;

import com.tutrieuchau.petbook.Utils.Utils;

/**
 * Created by tutr on 10/28/2017.
 */

public class PostHeader {
    public String postTitle;
    public String postTime;
    public int Icon;
    public Utils.POST_LIST_VIEW_TYPE postType;

    public PostHeader(String postTitle, String postTime, int icon, Utils.POST_LIST_VIEW_TYPE type) {
        this.postTitle = postTitle;
        this.postTime = postTime;
        Icon = icon;
        this.postType = type;
    }
}
