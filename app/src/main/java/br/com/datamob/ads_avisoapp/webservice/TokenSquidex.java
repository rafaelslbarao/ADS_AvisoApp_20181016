package br.com.datamob.ads_avisoapp.webservice;

import android.content.Context;

import com.android.volley.toolbox.StringRequest;

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


    public static void getToken(Context context)
    {
        //StringRequest
    }
}
