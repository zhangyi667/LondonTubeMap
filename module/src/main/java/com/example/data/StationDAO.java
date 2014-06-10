package com.example.data;

import java.util.List;

/**
 * Created by zhangyi667 on 14-6-10.
 */
public interface StationDAO {
    public List<Station> getAllStations();
    public void updateStation(Station Station);
    public void deleteStation(Station Station);

}
