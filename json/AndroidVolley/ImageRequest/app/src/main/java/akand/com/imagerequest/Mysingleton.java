package akand.com.imagerequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by TD06 on 5/30/2017.
 */

public class Mysingleton {
    private static Mysingleton mysingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private Mysingleton(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized Mysingleton getInstance(Context context){
        if (mysingleton == null){
            mysingleton = new Mysingleton(context);
        }
        return mysingleton;

    }
    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }


}
