package com.justmailtoavi.avinashk.utopia;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.core_team_adapter;


public class core_team_fragment extends Fragment {


    private List<core_team_adapter> core_list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.core_team_fragment,container,false);
        generateList();
        displayList(view);
        handleClicks(view);
        return view;
    }



    private void generateList() {

        core_list.add(new core_team_adapter("Gowtham Kumar", "7406059007"));
        core_list.add(new core_team_adapter("Karthik Rao", "8904663168"));
        core_list.add(new core_team_adapter("Sahana Lokare", "9036073108"));
        core_list.add(new core_team_adapter("Abhishek D Naik", "9482426466"));
        core_list.add(new core_team_adapter("SreeHari Chilukuri", "9742059832"));
        core_list.add(new core_team_adapter("Pooja Niloor ", "9741597224"));
        core_list.add(new core_team_adapter("T Supriya", "9535760313"));
        core_list.add(new core_team_adapter("Tejaswini","7259154719"));

        core_list.add(new core_team_adapter("Zain Shapoo", "9972103763"));
        core_list.add(new core_team_adapter("Vishnu Teja", "9000696834"));
        core_list.add(new core_team_adapter("Ganga Chidanand", "8105456419"));
        core_list.add(new core_team_adapter("Shilpi Jaiswal", "8147664370"));
        core_list.add(new core_team_adapter("Archi Choudhary ", "9986460285"));
        core_list.add(new core_team_adapter("Richa Jain ", "9591609502"));
        core_list.add(new core_team_adapter("Abhishek Sangwan", "8892053132"));
        core_list.add(new core_team_adapter("Snigdha C", "9019955611"));

        core_list.add(new core_team_adapter("Pankaj Shaw", "7406284638"));
        core_list.add(new core_team_adapter("Nikhil ", "9164836350"));
        core_list.add(new core_team_adapter("Akshay Sharma", "9591536760"));
        core_list.add(new core_team_adapter("Ashwini", "9591384197"));
        core_list.add(new core_team_adapter("Kaushik ", "8792384417"));
        core_list.add(new core_team_adapter("Ashoka", "8105463006"));

        core_list.add(new core_team_adapter("Aditi","9590741823"));
        core_list.add(new core_team_adapter("Shashi","8050519950"));

        core_list.add(new core_team_adapter("Alok Kumar","9663880829"));
        core_list.add(new core_team_adapter("Payal","990079758"));

    }

    private void displayList(View view) {
        ArrayAdapter<core_team_adapter> adapter = new myCoreTeamAdapter();
        ListView list = (ListView)view.findViewById(R.id.core_team_list);

        list.setAdapter(adapter);
    }

    private class myCoreTeamAdapter extends ArrayAdapter<core_team_adapter>{

        public myCoreTeamAdapter() {
           super(getActivity(),R.layout.core_team_fragment_item,core_list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView  =  convertView;
            if( itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.core_team_fragment_item,parent,false);
            }

            final core_team_adapter current = core_list.get(position);


            TextView text_name = (TextView) itemView.findViewById(R.id.core_name_item);
            text_name.setText(current.getName());

            TextView text_number = (TextView)itemView.findViewById(R.id.core_number_item);
            text_number.setText(current.getNumber());

            return itemView;
        }
    }


    private void handleClicks(View view) {

        ListView list = (ListView)view.findViewById(R.id.core_team_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                core_team_adapter click = core_list.get(position);
                String message = click.getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+message));
                startActivity(intent);
            }
        });
    }

}
