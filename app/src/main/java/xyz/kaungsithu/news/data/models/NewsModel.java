package xyz.kaungsithu.news.data.models;

import xyz.kaungsithu.news.network.HttpUrlConnectionDataAgent;
import xyz.kaungsithu.news.network.NewsDataAgent;

/**
 * Created by User on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel(){
        mDataAgent = HttpUrlConnectionDataAgent.geteObjInstance();
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
