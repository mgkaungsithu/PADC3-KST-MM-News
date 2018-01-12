package xyz.kaungsithu.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 12/17/2017.
 */

public class FavouriteVO {

    @SerializedName("favourite-id")
    private String favouriteId;
    private String favouriteDate;
    private ActedUserVO actedUser;

    public String getFavouriteId() {
        return favouriteId;
    }

    public String getFavouriteDate() {
        return favouriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }


}
