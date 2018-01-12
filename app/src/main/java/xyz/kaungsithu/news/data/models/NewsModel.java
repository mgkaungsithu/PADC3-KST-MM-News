package xyz.kaungsithu.news.data.models;

import xyz.kaungsithu.news.network.HttpUrlConnectionDataAgent;
import xyz.kaungsithu.news.network.NewsDataAgent;
import xyz.kaungsithu.news.network.RetrofitDataAgent;

/**
 * Created by User on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel(){

        //mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();
        //mDataAgent = OkHttpDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static NewsModel geteObjInstance(){
        if(sObjInstance==null){
            sObjInstance=new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * load news data from nerworklayer/api
     * */
    public void loadNews(){
          mDataAgent.loadNews();
    }
}
