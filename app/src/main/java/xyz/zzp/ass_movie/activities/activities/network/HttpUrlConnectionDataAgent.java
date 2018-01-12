package xyz.zzp.ass_movie.activities.activities.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import xyz.zzp.ass_movie.activities.activities.MovieApp;
import xyz.zzp.ass_movie.activities.activities.delegates.MovieActionDelegates;
import xyz.zzp.ass_movie.activities.activities.events.LoadedMovieEvent;
import xyz.zzp.ass_movie.activities.activities.network.responses.GetMovieResponse;

/**
 * Created by Lenovo on 1/1/2018.
 */

public class HttpUrlConnectionDataAgent implements MovieDataAgent {

    private static HttpUrlConnectionDataAgent sObjectInstance;

    private HttpUrlConnectionDataAgent() {
    }

    public static HttpUrlConnectionDataAgent getObjectInstance() {
        if(sObjectInstance == null) {
            sObjectInstance = new HttpUrlConnectionDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loadMovies() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                URL url;
                BufferedReader reader = null;
                StringBuilder stringBuilder;

                try {
                    url = new URL("http://padcmyanmar.com/padc-3/popular-movies/apis/v1/getPopularMovies.php");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("POST");

                    connection.setReadTimeout(15 * 1000);

                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    List<NameValuePair> params = new ArrayList<>();
                    params.add(new BasicNameValuePair("access_token", "b002c7e1a528b7cb460933fc2875e916"));
                    params.add(new BasicNameValuePair("page", "1"));

                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect();

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    stringBuilder = new StringBuilder();

                    String line = null;
                    while((line = reader.readLine())!= null){
                        stringBuilder.append(line + "\n");
                    }
                    String responseString = stringBuilder.toString();
                    Log.d(MovieApp.LOG_TAG,"response String"+responseString);

                    Gson gson = new Gson();
                    GetMovieResponse getMovieResponse = gson.fromJson(responseString,GetMovieResponse.class);
                    Log.d(MovieApp.LOG_TAG,"response "+getMovieResponse.getPopularMovies().size());

                    EventBus.getDefault().post(new LoadedMovieEvent(getMovieResponse.getPopularMovies()));

                } catch (Exception e){
                    Log.e(MovieApp.LOG_TAG,e.getMessage());
                } finally

                {
                    if (reader != null)
                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    return null;
                }
            }
        }.execute();
    }
    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
