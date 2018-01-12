package xyz.kaungsithu.news.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.kaungsithu.news.network.responses.GetNewsResponse;

/**
 * Created by User on 1/6/2018.
 */

public interface NewsApi {

    @FormUrlEncoded
    @POST("getMMNews.php")
     Call<GetNewsResponse>loadNews(@Field("page") int page,
                                   @Field("access_token") String accessToken);


}
