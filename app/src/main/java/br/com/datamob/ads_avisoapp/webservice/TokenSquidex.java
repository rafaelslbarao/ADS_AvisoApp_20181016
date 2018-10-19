package br.com.datamob.ads_avisoapp.webservice;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import br.com.datamob.ads_avisoapp.data.Token;

public class TokenSquidex
{
    private static final String url
            = "https://cloud.squidex.io/identity-server/connect/token";

    private static final String grant_type
            = "client_credentials";

    private static final String client_id
            = "avisosapp:androidapp";

    private static final String client_secret
            = "5ixsLdHiEiKpFAHxm4Z3FCKhufe/0L7bAXQBrg0XXjY=";

    private static final String scope
            = "squidex-api";

    private static Token token;


    public static void getToken(Context context,final GetTokenListener getTokenListener)
    {
        if(token == null)
        {
            StringRequest stringRequest
                    = new StringRequest(
                    Request.Method.POST,
                    url
                    , new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    token = new Gson().fromJson(response, Token.class);
                    getTokenListener.onSucesso(token);
                }
            }
                    , new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    getTokenListener.onFalha();
                }
            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> header = new HashMap<>();
                    header.put("Content-Type"
                            , "application/x-www-form-urlencoded");
                    return header;
                }

                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String, String> parametros = new HashMap<>();
                    parametros.put("grant_type"
                            , grant_type);
                    parametros.put("client_id"
                            , client_id);
                    parametros.put("client_secret"
                            , client_secret);
                    parametros.put("scope"
                            , scope);

                    return parametros;
                }
            };
            Chamadas.executa(context, stringRequest);
        }
        else
        {
            getTokenListener.onSucesso(token);
        }
    }

    public interface GetTokenListener
    {
        public void onFalha();
        public void onSucesso(Token token);
    }
}
