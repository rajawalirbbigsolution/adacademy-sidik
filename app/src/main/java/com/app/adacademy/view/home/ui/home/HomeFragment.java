package com.app.adacademy.view.home.ui.home;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.app.adacademy.R;
import com.app.adacademy.adapter.AdapterKordinat;
import com.app.adacademy.model.MasterKordinat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeFragment extends Fragment {


    private ArrayList<MasterKordinat> showMasterRute;

    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
               View root = inflater.inflate(R.layout.fragment_home, container, false);

        showMasterRute = (ArrayList<MasterKordinat>) SugarRecord.findWithQuery(MasterKordinat.class,"Select * from master_kordinat");

        AdapterKordinat flavorAdapter = new AdapterKordinat(getActivity(),R.layout.list_home,showMasterRute);


        ListView listView = (ListView) root.findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);
//        scheduleLandmark()

        return root;
    }

}