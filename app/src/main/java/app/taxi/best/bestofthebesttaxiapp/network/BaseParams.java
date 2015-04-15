package app.taxi.best.bestofthebesttaxiapp.network;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

/**
 * Created by eugene on 01.04.15.
 */
public class BaseParams {
    private String mUid = "1";
    private String mGcmId = "31231231";
    private String mMethod;

    private final String UID_KEY="uid";
    private final String GCM_ID_KEY="reg_id";
    private final String METHOD_KEY="method";

    public String getUid() {
        return mUid;
    }

    public void setUid(String mUid) {
        this.mUid = mUid;
    }

    public String getGcmId() {
        return mGcmId;
    }

    public void setGcmId(String mGcmId) {
        this.mGcmId = mGcmId;
    }

    public String getMethod() {
        return mMethod;
    }

    public void setMethod(String mMethod) {
        this.mMethod = mMethod;
    }

    public enum ApiMethod{
        GET("get"), POST("post");
        private String action;
        ApiMethod(String action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return action;
        }
    }

    protected Map compose(){
        Map map = new LinkedTreeMap();
        if(mUid!=null && !mUid.isEmpty()){
            map.put(UID_KEY, mUid);
        }
        if(mGcmId!=null && !mGcmId.isEmpty()){
            map.put(GCM_ID_KEY, mGcmId);
        }

        if(mMethod!=null && !mMethod.isEmpty()){
            map.put(METHOD_KEY, mMethod);
        }
        return map;
    }
}
