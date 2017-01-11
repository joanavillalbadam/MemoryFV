package com.exemple.profedam.memory.controllers;

/**
 * Created by ALUMNEDAM on 22/11/2016.
 */

import android.os.CountDownTimer;
import android.widget.TextView;

import com.exemple.profedam.memory.R;

/**
 * Created by ALUMNEDAM on 15/11/2016.
 */

public class Cronometre extends CountDownTimer{

    private MuestraCartas tauler;
    private TextView textView;


    public Cronometre(long milisInFuture, long countDownInterval, MuestraCartas tauler){
        super(milisInFuture, countDownInterval);
        this.tauler = tauler;
        textView = (TextView)tauler.findViewById(R.id.textTimeLeft);
    }
    /**
     * Aquest metode junt amb el se sobre imprimeix el temps en ms
     */
    @Override
    public void onTick(long millisUntilFinished) {
       // ((TextView) tauler.findViewById(R.id.textTimeLeft)).setText("Seconds remaining: "+ millisUntilFinished/1000);
        textView.setText("seconds:" + millisUntilFinished/1000);
    }

    public void onFinish() {
        this.onTick(0);
        textView.setText("se acabó");
        //Toast.makeText(tauler, "THE END", Toast.LENGTH_LONG).show();
        tauler.reiniciarPartida();

    }
}
