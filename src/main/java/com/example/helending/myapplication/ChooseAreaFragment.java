package com.example.helending.myapplication;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helending.myapplication.db.City;
import com.example.helending.myapplication.db.State;
import com.example.helending.myapplication.util.Utility;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by helending on 25/04/2017.
 */

public class ChooseAreaFragment extends Fragment {
    public static int LEVEL_STATE =0;
    public static int LEVEL_CITY = 1;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private Button backButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    private List<State> stateList;

    private List<City> cityList;

    private State selectedState;

    private int currentLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Utility.initializeStateCity();
        View view = inflater.inflate(R.layout.choose_area, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        backButton = (Button)view.findViewById(R.id.back_button);
        listView =(ListView)view.findViewById(R.id.list_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            adapter = new ArrayAdapter<String>(getContext(), R.layout.simple_list_item, dataList);
            listView.setAdapter(adapter);
        }
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentLevel == LEVEL_STATE){
                    selectedState = stateList.get(position);
                    queryCities();

                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(currentLevel  == LEVEL_CITY){
                    queryStates();
                }
            }
        });


    }

    private void queryStates(){
        titleText.setText("Australia");
        backButton.setVisibility(View.GONE);
        stateList = DataSupport.findAll(State.class);
        dataList.clear();
        for(State state: stateList){
            dataList.add(state.getStateName());
        }
        adapter.notifyDataSetChanged();
        listView.setSelection(0);
        currentLevel = LEVEL_STATE;

    }


    private void queryCities(){
        titleText.setText(selectedState.getStateName());
        backButton.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("stateid = ?", String.valueOf(selectedState.getId())).find(City.class);
        dataList.clear();
        for(City city: cityList){
            dataList.add(city.getCityName());
        }
        adapter.notifyDataSetChanged();
        listView.setSelection(0);
        currentLevel = LEVEL_CITY;




    }





}
