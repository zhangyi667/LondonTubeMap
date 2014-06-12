package com.tubemap.tubemap;

import android.os.Bundle;

import com.tubemap.data.Station;
import com.tubemap.data.StationImpDAO;

import java.util.List;

/**
 * Created by yangwan on 10/06/2014.
 */
public class TubeMapActivity extends ZoomInZoomOut{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        StationImpDAO stationsSet = new StationImpDAO(this);
        List<Station> stations = stationsSet.getAllStations();
    }
}
