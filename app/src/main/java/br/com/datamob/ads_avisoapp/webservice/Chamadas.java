package br.com.datamob.ads_avisoapp.webservice;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Chamadas
{
    private static RequestQueue requestQueue;

    private static RequestQueue getQueue(Context context)
    {
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);

        return requestQueue;
    }

    public static void executa(Context context, Request request)
    {
        getQueue(context).add(request);
    }
}
