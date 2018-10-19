package br.com.datamob.ads_avisoapp.webservice;

import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StringRequestToken extends StringRequest
{
    public StringRequestToken(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener)
    {
        super(method, url, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError
    {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type"
                , "application/x-www-form-urlencoded");
        return header;
    }
}
