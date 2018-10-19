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

import br.com.datamob.ads_avisoapp.data.Mensagens;
import br.com.datamob.ads_avisoapp.data.Token;

public class AvisoSquidex
{
    private static final String url = "https://cloud.squidex.io/api/content/avisosapp/aviso";


    public static void getMensagens(final Context context, final GetAvisosListener getAvisosListener)
    {
        TokenSquidex.getToken(context, new TokenSquidex.GetTokenListener()
        {
            @Override
            public void onFalha()
            {
                getAvisosListener.onFalha();
            }

            @Override
            public void onSucesso(Token token)
            {
                getMensagens(context, token, getAvisosListener);
            }
        });
    }

    private static void getMensagens(Context context, final Token token, final GetAvisosListener getAvisosListener)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , url
                , new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Mensagens mensagens = new Gson().fromJson(response, Mensagens.class);
                getAvisosListener.onSucesso(mensagens);
            }
        }
                , new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                getAvisosListener.onFalha();
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization"
                        , token.getToken_type() + " " + token.getAccess_token());
                return header;
            }
        };
        Chamadas.executa(context, stringRequest);
    }


    public interface GetAvisosListener
    {
        public void onFalha();

        public void onSucesso(Mensagens mensagens);
    }
}
