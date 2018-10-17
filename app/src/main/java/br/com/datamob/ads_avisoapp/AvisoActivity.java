package br.com.datamob.ads_avisoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AvisoActivity extends AppCompatActivity
{
    private EditText etAutor;
    private EditText etMensagem;
    private Button btSalvar;
    private ListView lvMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso);
        inicializaComponentes();
    }

    private void inicializaComponentes()
    {
        etAutor = findViewById(R.id.etAutor);
        etMensagem = findViewById(R.id.etMensagem);
        btSalvar = findViewById(R.id.btSalvar);
        lvMensagem = findViewById(R.id.lvMensagem);
    }
}
