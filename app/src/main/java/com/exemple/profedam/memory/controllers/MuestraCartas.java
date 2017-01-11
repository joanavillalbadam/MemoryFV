package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.exemple.profedam.memory.R;
import com.exemple.profedam.memory.model.Partida;

public class MuestraCartas extends AppCompatActivity {
    private GridView gv;
    private Partida partida;
    private ImageAdapter adapter;
    private CountDownTimer  timer;


    public GridView getGv() {
        return gv;
    }

    public void setGv(GridView gv) {
        this.gv = gv;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.muestracartas);
        // Intent intent = getIntent();
        gv = (GridView) findViewById(R.id.gridViewMemory);
        //TODO este 12 hay que calcularlo de alguna manera
        Intent intent = getIntent();
        //recoje la dificultad desde el intent
        int num = intent.getIntExtra("numCart",0);
        partida = new Partida (num);
        // timer = new Timer(2000, (TextView) findViewById(R.id.textTimeLeft));

        adapter = new ImageAdapter(this, partida);
        GeneralListener listener = new GeneralListener(this);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(listener);

        //muestra una cuenta atras
        Cronometre cronometre = new Cronometre(60000, 1000, this);
        cronometre.start();
        /*gv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(TaulerActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void refrescarTablero ()
    {
        //refresca el tablero
        gv.setAdapter(adapter);
        gv.refreshDrawableState();
    }

    public void reiniciarPartida() {
        //muestra un mensaje de que se a acabado la partida
        Toast.makeText(getApplicationContext(), "S'ha acabat el temps, pots acabar la partida o reiniciar",
                Toast.LENGTH_LONG).show();
    }
}


