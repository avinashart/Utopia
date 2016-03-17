package com.justmailtoavi.avinashk.utopia;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.events_list_adapter;


public class events_list_fragment extends Fragment {


    private List<events_list_adapter> event_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_list_fragment,container,false);


        generateList();
        displayList(view);
        //handleClicks(view);

        return view;
    }

    private void generateList() {
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess", "Karan", "3 per team", "Admin Block", ""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));
        event_list.add(new events_list_adapter("1", "Chess","Karan","3 per team","Admin Block",""));

    }

    private void displayList(View view) {
        ArrayAdapter<events_list_adapter> adapter = new myEventListAdapter();
        ListView list = (ListView)view.findViewById(R.id.all_events_list);
        list.setAdapter(adapter);
    }

    private class myEventListAdapter extends ArrayAdapter<events_list_adapter>{

        myEventListAdapter(){
            super(getActivity(),R.layout.event_list_fragment_item,event_list);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView  =  convertView;
            if( itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.event_list_fragment_item,parent,false);
            }
            events_list_adapter current = event_list.get(position);


            TextView name = (TextView) itemView.findViewById(R.id.event_eventName);
            name.setText(current.getEventName());

            return itemView;
        }
    }



}
