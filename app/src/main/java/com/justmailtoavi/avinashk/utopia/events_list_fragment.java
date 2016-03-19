package com.justmailtoavi.avinashk.utopia;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
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

import adapter.events_list_adapter;

public class events_list_fragment extends Fragment {


    private List<events_list_adapter> event_list = new ArrayList<>();
    ListView list;

    ArrayAdapter<events_list_adapter> adapter;

    static int serverVersion, localVersion;
    ProgressBar progressBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.events_list_fragment,container,false);
        progressBar = (ProgressBar)view.findViewById(R.id.progressbar);

        //Ask for permissions Android M
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        if (isNetworkConnected()) {
            SharedPreferences preferences = getActivity().getSharedPreferences("event_version", Context.MODE_PRIVATE);
            localVersion = preferences.getInt("version", 0);
           new EventVersionFile().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/events_version.json");
        } else {
            Toast.makeText(getActivity(),"No Internet Connection!",Toast.LENGTH_SHORT).show();
            loadJsonFile();
        }


        return view;
    }



    private void displayList(View view) {
        adapter = new myEventListAdapter();
        list = (ListView)view.findViewById(R.id.all_events_list1);
        list.setAdapter(adapter);
    }

    private class myEventListAdapter extends ArrayAdapter<events_list_adapter> {

        myEventListAdapter() {
            super(getActivity(), R.layout.event_list_fragment_item, event_list);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getActivity().getLayoutInflater().inflate(R.layout.event_list_fragment_item, parent, false);
            }
            events_list_adapter current = event_list.get(position);

            TextView name = (TextView) itemView.findViewById(R.id.event_eventName);
            name.setText(current.getEventName());
            TextView coor = (TextView) itemView.findViewById(R.id.event_coordinatorName);
            coor.setText(current.getCoordinator());

            return itemView;
            }
        }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private void loadJsonFile() {
        String ret = null;
        BufferedReader reader = null;
        File file = new File("/data/data/com.justmailtoavi.avinashk.utopia/events.json");
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

                JSONObject parent;
                try {
                    parent = new JSONObject(ret);
                    JSONArray newsArray = parent.getJSONArray("event_list");
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject child = newsArray.getJSONObject(i);
                        event_list.add(new events_list_adapter(child.getInt("event_day"),
                                child.getString("event_name"), child.getString("event_coordinator")));

                    }
                    displayList(view);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
        }else {
            //display demo values
            event_list.add(new events_list_adapter(1,"Test1","agent 1"));
            event_list.add(new events_list_adapter(1,"Test1","agent 1"));
            event_list.add(new events_list_adapter(1,"Test1","agent 1"));


            event_list.add(new events_list_adapter(2,"Test1","agent 1"));
            event_list.add(new events_list_adapter(2,"Test1","agent 1"));
            event_list.add(new events_list_adapter(2,"Test1","agent 1"));



            event_list.add(new events_list_adapter(3,"Test1","agent 1"));
            event_list.add(new events_list_adapter(3,"Test1","agent 1"));
            event_list.add(new events_list_adapter(3,"Test1","agent 1"));



            event_list.add(new events_list_adapter(4,"Test1","agent 1"));
            event_list.add(new events_list_adapter(4,"Test1","agent 1"));
            event_list.add(new events_list_adapter(4,"Test1","agent 1"));



            event_list.add(new events_list_adapter(5,"Test1","agent 1"));
            event_list.add(new events_list_adapter(5,"Test1","agent 1"));
            event_list.add(new events_list_adapter(5,"Test1","agent 1"));



            event_list.add(new events_list_adapter(6,"Test1","agent 1"));
            event_list.add(new events_list_adapter(6,"Test1","agent 1"));
            event_list.add(new events_list_adapter(6,"Test1","agent 1"));



            event_list.add(new events_list_adapter(7,"Test1","agent 1"));
            event_list.add(new events_list_adapter(7,"Test1","agent 1"));
            event_list.add(new events_list_adapter(7,"Test1","agent 1"));



            event_list.add(new events_list_adapter(8,"Test1","agent 1"));
            event_list.add(new events_list_adapter(8,"Test1","agent 1"));
            event_list.add(new events_list_adapter(8,"Test1","agent 1"));



            event_list.add(new events_list_adapter(9,"Test1","agent 1"));
            event_list.add(new events_list_adapter(9,"Test1","agent 1"));
            event_list.add(new events_list_adapter(9,"Test1","agent 1"));

            event_list.add(new events_list_adapter(10,"Test1","agent 1"));
            event_list.add(new events_list_adapter(10,"Test1","agent 1"));
            event_list.add(new events_list_adapter(10,"Test1","agent 1"));

            displayList(view);

        }
    }



    public class EventVersionFile extends AsyncTask<String, String, String> {
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
                JSONObject news_version = parent.getJSONObject("event_version");

                serverVersion = news_version.getInt("version");

                SharedPreferences preferences = getActivity().getSharedPreferences("event_version", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("version", serverVersion);
                editor.apply();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (localVersion != serverVersion)
                new eventFile().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/events.json");
            else
                Toast.makeText(getActivity(),"Events List Updated!",Toast.LENGTH_SHORT).show();

        }
    }



    public class eventFile extends AsyncTask<String, String, String> {

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


                //Json Parsing start
                JSONObject parent = new JSONObject(str);
                JSONArray newsArray = parent.getJSONArray("event_list");
                for (int i = 0; i < newsArray.length(); i++) {
                    JSONObject child = newsArray.getJSONObject(i);
                    event_list.add(new events_list_adapter(child.getInt("event_day"),
                            child.getString("event_name"), child.getString("event_coordinator")));
                }
                displayList(view);
                return null;


            } catch (IOException | JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


    private void saveJsonFile(String data) {
        FileOutputStream stream = null;
        try {
            File path = new File("/data/data/com.justmailtoavi.avinashk.utopia/events.json");
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
}
