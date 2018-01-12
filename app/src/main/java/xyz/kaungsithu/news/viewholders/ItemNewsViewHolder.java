package xyz.kaungsithu.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import butterknife.*;

import butterknife.ButterKnife;
import xyz.kaungsithu.news.R;
import xyz.kaungsithu.news.data.vo.NewsVO;
import xyz.kaungsithu.news.delegates.NewsActionDelegate;

/**
 * Created by Lenovo on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewsActionDelegate;
    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    @BindView(R.id.tv_newa_brief)
    TextView tvNewsBrief;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.lbl_news_statistics)
    TextView lblNewsStatistics;

    @BindView(R.id.iv_news_img)
    ImageView ivNews;


    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate)
    {


        super(itemView);
        ButterKnife.bind(this,itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick (R.id.cv_news_item_root)
    public void onNewsItemTap(View view){

        mNewsActionDelegate.onTapNewsItem();
 
    }
    public void setNews(NewsVO news){
        tvNewsDetails.setText(news.getPublication().getPublicationId());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBrief.setText(news.getBrief());
        Glide.with(ivPublicationLogo.getContext()).load(news.getPublication().getLogo()).into(ivPublicationLogo);

        if(news.getImages()!=null){
            Glide.with(ivNews.getContext()).load(news.getImages().get(0)).into(ivNews);
        }

    }

}
