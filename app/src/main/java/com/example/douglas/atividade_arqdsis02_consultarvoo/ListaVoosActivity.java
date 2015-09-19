package com.example.douglas.atividade_arqdsis02_consultarvoo;

/**
 * Created by Douglas on 11/09/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListaVoosActivity extends ActionBarActivity {
    ListView listView;
    Activity atividade;
    public final static String VOOS = "com.example.douglas.VOOS";
    Voos[] voos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);
        atividade = this;

        Especialista especialista = new Especialista();

        Intent intent = getIntent();//pega a mensagem do intent
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);
        String modo = intent.getStringExtra(MainActivity.MODO);

        voos = especialista.listarViagens(origem, destino).toArray(new Voos[0]);
        String[] lista = null;

        if(modo.equals(MainActivity.SIMPLES)) {
            lista = new String[voos.length];

            for (int i = 0; i < voos.length; i++) {
                lista[i] = voos[i].getNome();
            }
        }

        //cria a lista de cervejas
        listView = (ListView) findViewById(R.id.view_lista_voos);
        BaseAdapter adapter;
        if(modo.equals(MainActivity.SIMPLES)) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        } else {
            adapter = new VoosAdapter(this, voos);
        }
        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheVoosActivity.class);
                intent.putExtra(VOOS, voos[position]);

                startActivity(intent);

            }

        });
    }

}