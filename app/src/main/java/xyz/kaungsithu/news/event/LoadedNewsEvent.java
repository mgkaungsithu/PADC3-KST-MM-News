package xyz.kaungsithu.news.event;

import java.util.List;

import xyz.kaungsithu.news.data.vo.NewsVO;

/**
 * Created by User on 12/24/2017.
 */

public class LoadedNewsEvent {
    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public LoadedNewsEvent() {

    }

    public List<NewsVO> getNewsList(){
        return newsList;
    }

}
