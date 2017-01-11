package com.exemple.profedam.memory.controllers;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import com.exemple.profedam.memory.model.Carta;


/**
 * Created by ALUMNEDAM on 02/02/2016.
 */
public class GeneralListener implements AdapterView.OnItemClickListener, Runnable {

    private MuestraCartas tauler;
    private Carta cartaOnClick;
    private boolean listenerActive = true;
    private boolean isActive = true;

    public GeneralListener(MuestraCartas tauler) {
        this.tauler = tauler;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        if (isActive) {
            cartaOnClick = tauler.getPartida().getLlistaCartes().get(position);
            cartaOnClick.girar();
            tauler.refrescarTablero();
            //este metodo devuelve un array con las cartas que estan levantadas
            tauler.getPartida().devolverFront();
            //si hay 2 en front comprovara si son iguales si no dejara girar otra
            if(tauler.getPartida().getCartesFont().size() == 2 && tauler.getPartida().comprovaCartesIguals()){
                isActive = false;

                //Pausar la UI 2000 ms
               Handler delay = new Handler();
                delay.postDelayed(this, 1000);

                //run();
            }

         //   Toast.makeText(tauler, "position" + position, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void run() {
        //si las 2 son iguales las dejara fixed
        if(tauler.getPartida().getCartesFont().get(0).getFrontImage() == tauler.getPartida().getCartesFont().get(1).getFrontImage()){
            tauler.getPartida().getCartesFont().get(0).setEstat(Carta.Estat.FIXED);
            tauler.getPartida().getCartesFont().get(1).setEstat(Carta.Estat.FIXED);
        }else{
            //si no son iguales las girara
            tauler.getPartida().getCartesFont().get(0).setEstat(Carta.Estat.BACK);
            tauler.getPartida().getCartesFont().get(1).setEstat(Carta.Estat.BACK);

            //Handler delay = new Handler();
            //delay.postDelayed(this, 2000);

            //tauler.getPartida().getCartesFont().get(1).setEstat(Carta.Estat.BACK);
        }
        tauler.refrescarTablero();
        isActive = true;

    }
}
