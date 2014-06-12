package com.tubemap.data;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;

import com.tubemap.londontubemap.module.LondonTubeMapActivity;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



/**
 * Created by zhangyi667 on 14-6-10.
 */
public class StationImpDAO  implements StationDAO {

    static String stationsXMLFile = "Stations.xml";
    private Activity tubeActivity;

    public StationImpDAO(Activity activity) {
        this.tubeActivity = activity;
    }

    @Override
    public List<Station> getAllStations() {
        XmlPullParserFactory pullParserFactory;
        ArrayList <Station>stations = null;
        try {

            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = tubeActivity.getApplicationContext().getAssets().open(stationsXMLFile);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            stations = parseXML(parser);





        }catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }


        return stations;
    }

    private ArrayList parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {

        ArrayList<Station> stations = null;
        int eventType = parser.getEventType();
        Station currentStation = null;
        System.out.println("Start to build stations");

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;
            int id = 0;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    stations = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("Placemark")) {
                        id++;
                        currentStation = new Station(id);
                    }else if (currentStation != null){
                        if (name.equals("name")){
                            String stationName = parser.nextText();
                            currentStation.setName(stationName);
                        }else if (name.equals("description")){
                            currentStation.setDescription(parser.nextText());
                        }else if (name.equalsIgnoreCase("styleurl")){
                            currentStation.setTubeStyle(parser.nextText());
                        }
                    }
//                        else if (currentStation != null){
//                        if (name == "productname"){
//                            currentStation.name = parser.nextText();
//                        } else if (name == "productcolor"){
//                            currentStation.color = parser.nextText();
//                        } else if (name == "productquantity"){
//                            currentStation.quantity= parser.nextText();
//                        }
//                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("placemark") && currentStation != null) {
                        System.out.println("add station"+currentStation.getName());
                        stations.add(currentStation);
                    }
            }
            eventType = parser.next();

        }

        return stations;

    }
    @Override
    public void updateStation(Station Station) {

    }

    @Override
    public void deleteStation(Station Station) {

    }
}
