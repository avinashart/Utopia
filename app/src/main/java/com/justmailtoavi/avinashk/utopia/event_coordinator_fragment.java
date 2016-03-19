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

import adapter.coordinators_adapter;

public class event_coordinator_fragment extends Fragment {


    private List<coordinators_adapter> coordinator_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_coordinator_fragment,container,false);


        generateList();
        displayList(view);
        handleClicks(view);

        return view;
    }


    private void generateList() {




        //Room 107
        coordinator_list.add(new coordinators_adapter("M Vinay Sagar", "9008547253"));
        coordinator_list.add(new coordinators_adapter("Sujith SDV", "9731471041"));
        coordinator_list.add(new coordinators_adapter("Karan Sowdri", "9844494343"));
        coordinator_list.add(new coordinators_adapter("Avinash K", "9880430068"));


        coordinator_list.add(new coordinators_adapter("Pranav Kulkarni","7760698014"));
        coordinator_list.add(new coordinators_adapter("Pyush Kumar","9164129269"));

        coordinator_list.add(new coordinators_adapter("Srikanth B", "9590435585"));
        coordinator_list.add(new coordinators_adapter("Gagan D M", "8553438893"));
        coordinator_list.add(new coordinators_adapter("Manthan Mittal", "8892525477"));

        coordinator_list.add(new coordinators_adapter("Vinod Biradar", "9632069169"));
        coordinator_list.add(new coordinators_adapter("Mahendra", "9980105336"));
        coordinator_list.add(new coordinators_adapter("Chandan", "9611529869"));

        coordinator_list.add(new coordinators_adapter("Arun R Rao","9481243549"));
        coordinator_list.add(new coordinators_adapter("Ajith Rao","7259269042"));
        coordinator_list.add(new coordinators_adapter("Arun S","9743394513"));
        coordinator_list.add(new coordinators_adapter("Akash S S","7338624353"));
        coordinator_list.add(new coordinators_adapter("Vignesh Kavil","8861918393"));
        coordinator_list.add(new coordinators_adapter("Ajay Bhat","7829601027"));
        coordinator_list.add(new coordinators_adapter("Harsha Kadamba","9731034531"));
        coordinator_list.add(new coordinators_adapter("Ashok G N","8152002295"));
        coordinator_list.add(new coordinators_adapter("Chethan S R","8197654134"));

        coordinator_list.add(new coordinators_adapter("Akshay JS","9481642963"));
        coordinator_list.add(new coordinators_adapter("Nandan Kumar","9141368339"));

        coordinator_list.add(new coordinators_adapter("Vinay Kumar","8892625494"));
        coordinator_list.add(new coordinators_adapter("Samrat C","9916899428"));
        coordinator_list.add(new coordinators_adapter("Sharath Kumar","9036056321"));
        coordinator_list.add(new coordinators_adapter("Shamanth H V","9008491385"));
        coordinator_list.add(new coordinators_adapter("Ashish H M","9986467733"));
        coordinator_list.add(new coordinators_adapter("Akshay Dalavai","8762454321"));
        coordinator_list.add(new coordinators_adapter("Ujjwal Raina","9036163910"));

        coordinator_list.add(new coordinators_adapter("Prakhar Gupta","9741657201"));
        coordinator_list.add(new coordinators_adapter("Taposh Desai","9448023874"));
        coordinator_list.add(new coordinators_adapter("Keshav Gowda","9916790652"));
        coordinator_list.add(new coordinators_adapter("Kaushal C","9481432713"));
        coordinator_list.add(new coordinators_adapter("Abhishek Shetty","9731055979"));
        coordinator_list.add(new coordinators_adapter("J Gokul","9739693077"));
        coordinator_list.add(new coordinators_adapter("Sughosh R J","8892520028"));



        coordinator_list.add(new coordinators_adapter("K Samanth","9972366238"));
        coordinator_list.add(new coordinators_adapter("Gaurav SN","8884510065"));
        coordinator_list.add(new coordinators_adapter("Ajay Gali","8147948779"));
        coordinator_list.add(new coordinators_adapter("Raj Poddar","9591098782"));
        coordinator_list.add(new coordinators_adapter("Pradeep Kumar","9980993914"));


        coordinator_list.add(new coordinators_adapter("Pavan D.K","9535395424"));
        coordinator_list.add(new coordinators_adapter("Manjunath","8880016089"));
        coordinator_list.add(new coordinators_adapter("Ajay Telkar","8892826679"));
        coordinator_list.add(new coordinators_adapter("Prajwal T.P","9538662270"));
        coordinator_list.add(new coordinators_adapter("Yash Mishra","8951672196"));
        coordinator_list.add(new coordinators_adapter("Kishore Mullolli","8497046640"));
        coordinator_list.add(new coordinators_adapter("Hanu Sravanth.T","7760237979"));
        coordinator_list.add(new coordinators_adapter("Karthik Chandra","9741402725"));
        coordinator_list.add(new coordinators_adapter("Suhas Bhat","8123540636"));
        coordinator_list.add(new coordinators_adapter("Yashwanth Reddy","9901604686"));
        coordinator_list.add(new coordinators_adapter("Rishabh Tripathi","7795910934"));


        coordinator_list.add(new coordinators_adapter("Akshay Anand","9972938779"));
        coordinator_list.add(new coordinators_adapter("Krishna Kumar","9902120347"));
        coordinator_list.add(new coordinators_adapter("Prashanth Kallur","9906195578"));
        coordinator_list.add(new coordinators_adapter("Kaushik Anagarkar","8792384417"));
        coordinator_list.add(new coordinators_adapter("Kiran Nagonde","9481782981"));
        coordinator_list.add(new coordinators_adapter("Hari Krishna","7204672201"));
        coordinator_list.add(new coordinators_adapter("Rakesh Bombale","9590727231"));
        coordinator_list.add(new coordinators_adapter("Sharan Kumar","7795702080"));
        coordinator_list.add(new coordinators_adapter("Abhishek S K","9482492255"));
        coordinator_list.add(new coordinators_adapter("Shantesh","8147221503"));
        coordinator_list.add(new coordinators_adapter("Arnav Shrivastav","9986465674"));
        coordinator_list.add(new coordinators_adapter("Sparsh Pathak","8904613140"));
        coordinator_list.add(new coordinators_adapter("Abhishek Sangwan","8892053132"));
        coordinator_list.add(new coordinators_adapter("Sunil S Gouda","7676891957"));
        coordinator_list.add(new coordinators_adapter("Mehaboob Basha Shaik","9590630934"));
        coordinator_list.add(new coordinators_adapter("Rakesh","9535631975"));
        coordinator_list.add(new coordinators_adapter("Raj Gaurav","9986684712"));


        coordinator_list.add(new coordinators_adapter("Basha","9590630934"));
        coordinator_list.add(new coordinators_adapter("Anshul Bansal","9900819178"));


        coordinator_list.add(new coordinators_adapter("Ajooba Alam","8867506979"));
        coordinator_list.add(new coordinators_adapter("Raghavendra","9035309345"));
        coordinator_list.add(new coordinators_adapter("Rudro","9886384370"));
        coordinator_list.add(new coordinators_adapter("Rahul","7411679232"));
        coordinator_list.add(new coordinators_adapter("Manigandan R","8904451044"));
        coordinator_list.add(new coordinators_adapter("Maurya","9449141653"));
        coordinator_list.add(new coordinators_adapter("Sandesh M.G","9480583011"));
        coordinator_list.add(new coordinators_adapter("Vilas D Rathod ","9945085335"));
        coordinator_list.add(new coordinators_adapter("Bhargava C.S","9986154040"));
        coordinator_list.add(new coordinators_adapter("Shravan Pandey","9986460386"));
        coordinator_list.add(new coordinators_adapter("Raunak Verma","9980109128"));
        coordinator_list.add(new coordinators_adapter("Nikhil Prakash","9164836350"));
        coordinator_list.add(new coordinators_adapter("Sonu Bhaskar","8553991353"));
        coordinator_list.add(new coordinators_adapter("Abhinav","8553181803"));
        coordinator_list.add(new coordinators_adapter("Shubham Jain","9066616911"));



        coordinator_list.add(new coordinators_adapter("Anshu Sharma","8884083422"));
        coordinator_list.add(new coordinators_adapter("Archana Chokhani","9036272144"));
        coordinator_list.add(new coordinators_adapter("Sonali Gupta","9980920976"));
        coordinator_list.add(new coordinators_adapter("Jainab N Annigeri","7406125786"));
        coordinator_list.add(new coordinators_adapter("Madhura","9740100515"));
        coordinator_list.add(new coordinators_adapter("Pooja","7411764960"));
        coordinator_list.add(new coordinators_adapter("Pushpa N Bhat","9482113560"));
        coordinator_list.add(new coordinators_adapter("Ganga M C","8105456419"));
        coordinator_list.add(new coordinators_adapter("Swathi G R","9066116899"));
        coordinator_list.add(new coordinators_adapter("Arpitha H A","7259750785"));
        coordinator_list.add(new coordinators_adapter("Arpitha S","9632282822"));
        coordinator_list.add(new coordinators_adapter("C V Manogna","7760257857"));
        coordinator_list.add(new coordinators_adapter("Snigdha C","9019955611"));
        coordinator_list.add(new coordinators_adapter("Archi Choudhary","9986460285"));
        coordinator_list.add(new coordinators_adapter("Shatakshi Jaiswal","8123545664"));
        coordinator_list.add(new coordinators_adapter("Ashwini Hegde","9591384197"));
        coordinator_list.add(new coordinators_adapter("Richa Jain","9591609502"));
        coordinator_list.add(new coordinators_adapter("Nisha","9972172605"));
        coordinator_list.add(new coordinators_adapter("Payal Kumari","9900797580"));
        coordinator_list.add(new coordinators_adapter("Pooja S Niloor","9741597224"));
        coordinator_list.add(new coordinators_adapter("Sumana","9731767561"));
        coordinator_list.add(new coordinators_adapter("Shruti K","9901735436"));
        coordinator_list.add(new coordinators_adapter("Soumya Pandit U","9008795377"));

        coordinator_list.add(new coordinators_adapter("Sourabha Shetty","9902655935"));
        coordinator_list.add(new coordinators_adapter("Prachi Kumari","8123515256"));
        coordinator_list.add(new coordinators_adapter("Sahana K L","9036073108"));
        coordinator_list.add(new coordinators_adapter("Seva Kumari","7676570301"));
        coordinator_list.add(new coordinators_adapter("Akanksha","8867688407"));
        coordinator_list.add(new coordinators_adapter("Zamra Akhtar","7411973447"));
        coordinator_list.add(new coordinators_adapter("Aditi Anmol","9590791823"));
        coordinator_list.add(new coordinators_adapter("Chinmai Kulkarni","7259797746"));
        coordinator_list.add(new coordinators_adapter("Lavanya Chelle","7406981839"));
        coordinator_list.add(new coordinators_adapter("Pooja B J","9741215463"));
        coordinator_list.add(new coordinators_adapter("Aishwarya Barikeri","8095162823"));
        coordinator_list.add(new coordinators_adapter("Akanksha Tiwari","9742535318"));
        coordinator_list.add(new coordinators_adapter("Shilpi Jaiswal","8095629587"));
        coordinator_list.add(new coordinators_adapter("T Supriya","9535760313"));
        coordinator_list.add(new coordinators_adapter("Tejaswini G P","7259154719"));


    }

    private void displayList(View view) {
        ArrayAdapter<coordinators_adapter> adapter = new myCoordinatorsAdapter();
        ListView list = (ListView)view.findViewById(R.id.coordinator_list);
        list.setAdapter(adapter);
    }

    private class myCoordinatorsAdapter extends ArrayAdapter<coordinators_adapter>{

        public myCoordinatorsAdapter() {
            super(getActivity(),R.layout.coordinators_list_item,coordinator_list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView  =  convertView;
            if( itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.coordinators_list_item,parent,false);
            }

            coordinators_adapter current = coordinator_list.get(position);


            TextView text_name = (TextView) itemView.findViewById(R.id.coordinator_name_item);
            text_name.setText(current.getName());

            TextView text_number = (TextView)itemView.findViewById(R.id.coordinator_number_item);
            text_number.setText(current.getNumber());


            return itemView;
        }
    }

    private void handleClicks(View view) {

        ListView list = (ListView)view.findViewById(R.id.coordinator_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                coordinators_adapter click = coordinator_list.get(position);
                String message = click.getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + message));
                startActivity(intent);
            }
        });
    }


}
