package com.justmailtoavi.avinashk.utopia;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.winner_adapter;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;


public class winner_list extends AppCompatActivity {


    private List<winner_adapter> winner_adapterList = new ArrayList<>();
    static int serverVersion, localVersion;

    WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.main_swipe2);


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(winner_list.this,MainActivity.class);
                startActivity(intent);
            }
        });


        //Ask for permissions Android M
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        loadJsonFile();
        Toast.makeText(this,"Swipe down to refresh contents..", Toast.LENGTH_SHORT).show();


        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWaveSwipeRefreshLayout.setRefreshing(true);
                if(isNetworkConnected()){
                    SharedPreferences preferences = getSharedPreferences("winner_version", Context.MODE_PRIVATE);
                    localVersion = preferences.getInt("version", 0);
                    new WinnerVersion().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/winner_version.json");
                }else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection!", Toast.LENGTH_SHORT).show();
                    mWaveSwipeRefreshLayout.setRefreshing(false);
                }

            }
        });

    }

    private void loadJsonFile() {
        String ret = null;
        BufferedReader reader = null;
        File file = new File("/data/data/com.justmailtoavi.avinashk.utopia/winner.json");
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(fis));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                ret = builder.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            try {
                JSONObject parent = new JSONObject(ret);
                JSONArray eventJson = parent.getJSONArray("winner_list");

                for (int i = 0;i<eventJson.length();i++){
                    JSONObject child = eventJson.getJSONObject(i);
                    winner_adapterList.add(new winner_adapter(child.getString("event_name"),child.getString("event_winner"),child.getString("event_team")));
                }
                displayList();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public class WinnerVersion extends AsyncTask<String, String, String> {
        HttpURLConnection connection;
        BufferedReader reader;

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject parent = new JSONObject(s);
                JSONObject news_version = parent.getJSONObject("winner_version");

                serverVersion = news_version.getInt("version");

                SharedPreferences preferences = getSharedPreferences("winner_version", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("version", serverVersion);
                editor.apply();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (localVersion != serverVersion){
                new winnerFile().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/winner.json");
            }
            else{
                Toast.makeText(getApplication(),"Winner's List is up to date!",Toast.LENGTH_SHORT).show();
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }

        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    public class winnerFile extends AsyncTask<String, String, String> {

        HttpURLConnection connection;
        BufferedReader reader;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                String str = builder.toString();
                saveJsonFile(str);
                return str;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                mWaveSwipeRefreshLayout.setRefreshing(false);
                JSONObject parent = new JSONObject(s);
                JSONArray eventJson = parent.getJSONArray("winner_list");
                for (int i = 0;i<eventJson.length();i++){
                    JSONObject child = eventJson.getJSONObject(i);
                    winner_adapterList.add(new winner_adapter(child.getString("event_name"),child.getString("event_winner"),child.getString("event_team")));
                }
                displayList();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    private void displayList() {
        ArrayAdapter<winner_adapter> adapter = new myWinnerListAdapter();
        ListView list = (ListView)findViewById(R.id.winner_list);
        list.setAdapter(adapter);
    }


    private class myWinnerListAdapter extends ArrayAdapter<winner_adapter> {

        myWinnerListAdapter() {
            super(getApplication(), R.layout.winner_list_item, winner_adapterList);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.winner_list_item, parent, false);
            }
            winner_adapter current = winner_adapterList.get(position);

            TextView w_event = (TextView)itemView.findViewById(R.id.w_event);
            w_event.setText(current.getEventName());

            TextView w_name = (TextView)itemView.findViewById(R.id.w_name);
            w_name.setText(current.getWinnerName());

            TextView w_team = (TextView)itemView.findViewById(R.id.w_team);
            w_team.setText(current.getTeamName());

            return itemView;
        }
    }

    private void saveJsonFile(String data) {
        FileOutputStream stream = null;
        try {
            File path = new File("/data/data/com.justmailtoavi.avinashk.utopia/winner.json");
            stream = new FileOutputStream(path);
            stream.write(data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
      finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(winner_list.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
