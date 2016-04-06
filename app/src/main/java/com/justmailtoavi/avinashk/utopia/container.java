package com.justmailtoavi.avinashk.utopia;

import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;



public class container extends Fragment {

    static int serverVersionWinner,localVersionWinner,serverVersionGallery,localVersionGallery,localGeneralVersion,serverGeneralVersion;
    View view;

    NotificationCompat.Builder winner_notification,gallery_notification,general_notification;
    private static final int unique_winner = 909,unique_gallery = 123,unique_general = 100;

    Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.container, container, false);


        winner_notification = new NotificationCompat.Builder(getActivity());
        winner_notification.setAutoCancel(true);

        gallery_notification = new NotificationCompat.Builder(getActivity());
        gallery_notification.setAutoCancel(true);


        general_notification =  new NotificationCompat.Builder(getActivity());
        general_notification.setAutoCancel(true);


                SliderLayout mDemoSlider = (SliderLayout) view.findViewById(R.id.mainActivitySlider);
                final HashMap<String,Integer> file_maps = new HashMap<>();
                file_maps.put("Vijayanagar Vikings",R.drawable.vijaynagar);
                file_maps.put("Hoysala Pirates",R.drawable.hoysala);
                file_maps.put("Kalinga Kings",R.drawable.kalinga);
                file_maps.put("Magadha Warriors", R.drawable.maurya);

                for(String name : file_maps.keySet()){
                    TextSliderView textSliderView = new TextSliderView(getActivity());
                    // initialize a SliderLayout
                    textSliderView
                            .description(name)
                            .image(file_maps.get(name))
                            .setScaleType(BaseSliderView.ScaleType.Fit);

                    //add your extra information
                    textSliderView.bundle(new Bundle());
                    textSliderView.getBundle()
                            .putString("extra",name);

                    mDemoSlider.addSlider(textSliderView);
                }

                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                mDemoSlider.setDuration(6000);

        if (isNetworkConnected()){
            checkForWinnerListChanges();
            checkForgalleryListChanges();
        }
        return view;
    }



    private void checkForWinnerListChanges() {
        SharedPreferences preferences = (getActivity()).getSharedPreferences("winner_version", Context.MODE_PRIVATE);
        localVersionWinner = preferences.getInt("version", 0);
        new checkWinnerVersion().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/winner_version.json");
    }


    private void checkForgalleryListChanges() {
        SharedPreferences preferences = (getActivity()).getSharedPreferences("gallery_version", Context.MODE_PRIVATE);
        localVersionGallery = preferences.getInt("version", 0);
        new CheckGalleryVersion().execute("https://googledrive.com/host/0B4MrAIPM8gwfa3ZMM3E5UUhQU0E/gallery_version.json");
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    public class checkWinnerVersion extends AsyncTask<String, String, String> {
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
                serverVersionWinner = news_version.getInt("version");

                if (localVersionWinner != serverVersionWinner){

                    winner_notification.setSmallIcon(R.drawable.notification);
                    winner_notification.setTicker("Winner List content update available");
                    winner_notification.setWhen(System.currentTimeMillis());
                    winner_notification.setContentTitle("UTOPIA 2016");
                    winner_notification.setColor(0xff66BB6A);
                    winner_notification.setSound(sound);
                    winner_notification.setContentText("Winner's List updated");

                    Intent intent = new Intent(getActivity(),winner_list.class);


                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getActivity());
                    stackBuilder.addParentStack(MainActivity.class);
                    stackBuilder.addNextIntent(intent);


                    PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                    winner_notification.setContentIntent(pendingIntent);

                    NotificationManager nm = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                    nm.notify(unique_winner,winner_notification.build());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }




    public class CheckGalleryVersion extends AsyncTask<String, String, String> {
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
                JSONObject news_version = parent.getJSONObject("gallery_version");

                serverVersionGallery = news_version.getInt("version");

                if (localVersionGallery != serverVersionGallery) {

                    gallery_notification.setSmallIcon(R.drawable.notification);
                    gallery_notification.setTicker("New Photos in Gallery");
                    gallery_notification.setWhen(System.currentTimeMillis());
                    gallery_notification.setColor(0xff66BB6A);
                    gallery_notification.setSound(sound);
                    gallery_notification.setContentTitle("UTOPIA 2016");
                    gallery_notification.setContentText("New Images are available in Gallery");

                    Intent intent = new Intent(getActivity(),gallery.class);

                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getActivity());
                    stackBuilder.addParentStack(MainActivity.class);
                    stackBuilder.addNextIntent(intent);

                    PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    gallery_notification.setContentIntent(pendingIntent);
                    NotificationManager nm = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                    nm.notify(unique_gallery,gallery_notification.build());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }






    public class FetchGeneralFile extends AsyncTask<String, String, String> {
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
                JSONObject news_version = parent.getJSONObject("general");
                String message = news_version.getString("message");

                general_notification.setSmallIcon(R.drawable.notification);
                general_notification.setWhen(System.currentTimeMillis());
                general_notification.setColor(0xff66BB6A);
                general_notification.setSound(sound);
                general_notification.setContentTitle("UTOPIA 2016");
                general_notification.setContentText(message);

                Intent intent = new Intent(getActivity(),MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                general_notification.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(unique_general, general_notification.build());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }






}
