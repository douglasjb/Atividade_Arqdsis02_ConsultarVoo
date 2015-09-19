package com.example.douglas.atividade_arqdsis02_consultarvoo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Douglas on 19/09/2015.
 */
public class DetalheVoosActivity extends ActionBarActivity {

    TextView voosNome;
    ImageView voosImageView;
    TextView voosOrigem;
    TextView voosDestino;
    TextView voosData;
    TextView voosHorario;
    TextView voosCompanhia;
    TextView voosPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_voos);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaVoosActivity.VOOS);
        Voos voos = (Voos)obj;
        setupViews(voos);

    }

    private void setupViews(Voos voos) {
        voosNome = (TextView) findViewById(R.id.txt_voos_nome);
        voosNome.setText(voos.getNome());
        voosImageView = (ImageView) findViewById(R.id.voos_image_view);
        Drawable drawable = Util.getDrawable(this, voos.getImagem());
        voosImageView.setImageDrawable(drawable);
        voosOrigem = (TextView) findViewById(R.id.txt_voos_origem);
        voosOrigem.setText(voos.getOrigem());
        voosDestino = (TextView) findViewById(R.id.txt_voos_destino);
        voosDestino.setText(voos.getDestino());
        voosData = (TextView) findViewById(R.id.txt_voos_data);
        voosData.setText(voos.getData());
        voosHorario = (TextView) findViewById(R.id.txt_voos_horario);
        voosHorario.setText(voos.getHorario());
        voosCompanhia = (TextView) findViewById(R.id.txt_voos_companhia);
        voosCompanhia.setText(voos.getCompanhia());
        voosPreco = (TextView) findViewById(R.id.txt_voos_preco);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        voosPreco.setText(""+formatter.format(voos.getPreco()));
    }

}

