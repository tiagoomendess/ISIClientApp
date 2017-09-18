package isi.isiclientapp;

/**
 * Created by tiago on 16/09/2017.
 */

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {

    String url;
    String data ="";
    boolean authorized;
    RelativeLayout rl;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL api_url = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) api_url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data += line;
            }

            JSONObject JO = new JSONObject(data);

            authorized = (boolean) JO.get("authorized");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (authorized)
            MainActivity.relativeLayout.setBackgroundColor(Color.GREEN);
        else
            MainActivity.relativeLayout.setBackgroundColor(Color.RED);

    }
}