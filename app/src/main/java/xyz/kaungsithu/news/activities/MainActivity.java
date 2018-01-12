package xyz.kaungsithu.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xyz.kaungsithu.news.MMNewsApp;

import butterknife.*;
import butterknife.ButterKnife;
import xyz.kaungsithu.news.*;
import xyz.kaungsithu.news.adapters.NewsAdapter;
import xyz.kaungsithu.news.data.models.NewsModel;
import xyz.kaungsithu.news.delegates.NewsActionDelegate;
import xyz.kaungsithu.news.event.LoadedNewsEvent;
import xyz.kaungsithu.news.R;

public class MainActivity extends AppCompatActivity
        implements NewsActionDelegate {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);// initialization

        setSupportActionBar(toolbar);

        mNewsAdapter = new NewsAdapter(this);

//        LinearLayoutManager linearLayoutManagernear = new LinearLayoutManager(getApplicationContext(),
//                LinearLayoutManager.HORIZONTAL,false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);

        rvNews.setLayoutManager(gridLayoutManager);

        rvNews.setAdapter(mNewsAdapter);

        NewsModel.geteObjInstance().loadNews();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTapFab(View view){
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapNewsItem() {
        Intent intent = new Intent(getApplicationContext(),NewsDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSentToButton() {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void onNewsLoaded(LoadedNewsEvent event){
        Log.d(MMNewsApp.LOG_TAG,"onNewsLoaded:"+event.getNewsList().size());
        mNewsAdapter.setNews(event.getNewsList());

    }

}
