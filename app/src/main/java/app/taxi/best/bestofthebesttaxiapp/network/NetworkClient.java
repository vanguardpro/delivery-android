package app.taxi.best.bestofthebesttaxiapp.network;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by eugene on 01.04.15.
 */
public class NetworkClient {
    public static final String API_KEY = "1qA34-80";

    private static NetworkClient instance;
    private final static String TAG = "NetworkClient";
    private final static String BASE_URL = "http://iteebula.info";
    private RestAdapter mRestAdapter;

    private NetworkClient(Context context) {

        mRestAdapter = new RestAdapter.Builder()
                .setClient(new HttpUrlConnectionClient())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build();
    }

    public static NetworkClient get(Context context) {
        if (instance == null) {
            synchronized (NetworkClient.class) {
                Log.d(TAG, "NEW OBJECT");
                instance = new NetworkClient(context);
            }
        }
        return instance;
    }

    public void sendLocation(LocationParams locationParams, Callback callback) {
        INetworkClient iNetworkClient = mRestAdapter.create(INetworkClient.class);
        iNetworkClient.sendLocation(locationParams.compose(), callback);
    }

    public interface INetworkClient {
        @GET("/")
        public void sendLocation(@QueryMap Map<String, String> options, Callback<JSONObject> cb);


    }
    public final class HttpUrlConnectionClient extends UrlConnectionClient {
        @Override
        protected HttpURLConnection openConnection(Request request) {
            HttpURLConnection connection = null;
            try {
                connection = super.openConnection(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connection.setConnectTimeout(15 * 1000);
                connection.setReadTimeout(30 * 1000);
            }
            return connection;
        }
    }
}
