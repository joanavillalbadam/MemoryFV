package com.exemple.profedam.memory.controllers;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.exemple.profedam.memory.R;
import com.exemple.profedam.memory.model.Partida;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Partida partida;
    private int al;
    private int an;
  //  private MainActivity tauler;
   // private int numColumnas, anchoColumna, alturaColumna;


    public ImageAdapter(Context c, Partida p) {

        mContext = c;
        partida = p;
        //calcular las dimensiones del movil
      WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
       DisplayMetrics displayMetrics = new DisplayMetrics();
       display.getMetrics(displayMetrics);
        //calcular la dimension de la carta a partir de las dimensiones del telefono
        al = (int)((displayMetrics.widthPixels*0.9)/4);
        an = (al*320/280);

    }


    public int getCount() {

        return partida.getNumeroCartes();

    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(al,an));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(8, 8, 8, 8);

            /* TODO hay que visualizar la imagen de la carta
            correspondiente del ArrayList */
             imageView.setImageResource (partida.getLlistaCartes().get(position).getActive());
            // imageView.setImageResource(R.drawable.back);

        } else {
            imageView = (ImageView) convertView;
        }

        return imageView;
    }
       /* 1) Hacer que salgan 6 pares de cartas, y no 12 sueltas
          2) Hacer que salgan BACK
          3) El click gire la carta.
        */
















}
