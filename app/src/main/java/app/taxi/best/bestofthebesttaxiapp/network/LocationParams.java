package app.taxi.best.bestofthebesttaxiapp.network;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

/**
 * Created by eugene on 01.04.15.
 */
public class LocationParams extends BaseParams {
    private String mLng;
    private String mLat;
    private final String LAT_KEY="lat";
    private final String LNG_KEY="lng";

    public String getLat() {
        return mLat;
    }

    public void setLat(Double mLat) {
        this.mLat = String.valueOf(mLat);
    }

    public String getLng() {
        return mLng;
    }

    public void setLng(Double mLng) {
        this.mLng = String.valueOf(mLng);
    }

    protected Map compose(){
        Map map = super.compose();
        if(mLng!=null && !mLng.isEmpty()){
            map.put(LNG_KEY, mLng);
        }
        if(mLat!=null && !mLat.isEmpty()){
            map.put(LAT_KEY, mLat);
        }
        return map;
    }
}
