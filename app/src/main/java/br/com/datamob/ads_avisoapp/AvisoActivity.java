package br.com.datamob.ads_avisoapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.net.HttpURLConnection;

import br.com.datamob.ads_avisoapp.data.DataMensagem;
import br.com.datamob.ads_avisoapp.data.Mensagens;
import br.com.datamob.ads_avisoapp.data.Token;
import br.com.datamob.ads_avisoapp.webservice.AvisoSquidex;
import br.com.datamob.ads_avisoapp.webservice.TokenSquidex;

public class AvisoActivity extends AppCompatActivity
{
    private EditText etAutor;
    private EditText etMensagem;
    private Button btSalvar;
    private ListView lvMensagem;
    private Mensagens mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso);
        inicializaComponentes();
        AvisoSquidex.getMensagens(this, new AvisoSquidex.GetAvisosListener()
        {
            @Override
            public void onFalha()
            {

            }

            @Override
            public void onSucesso(Mensagens mensagens)
            {
                AvisoActivity.this.mensagens = mensagens;
                ((ArrayAdapter)lvMensagem.getAdapter()).notifyDataSetChanged();
            }
        });
    }



    private void inicializaComponentes()
    {
        etAutor = findViewById(R.id.etAutor);
        etMensagem = findViewById(R.id.etMensagem);
        btSalvar = findViewById(R.id.btSalvar);
        lvMensagem = findViewById(R.id.lvMensagem);
        lvMensagem.setAdapter(new ArrayAdapter<DataMensagem>(this, android.R.layout.simple_list_item_1)
        {

            @Nullable
            @Override
            public DataMensagem getItem(int position)
            {
                return mensagens != null ? mensagens.getItems().get(position).getData() : null;
            }

            @Override
            public int getCount()
            {
                return mensagens != null ? mensagens.getTotal().intValue() : 0;
            }
        });
    }
}
