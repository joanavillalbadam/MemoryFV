package com.exemple.profedam.memory.model;

import com.exemple.profedam.memory.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ALUMNEDAM on 29/01/2016.
 */
public class Partida {

    ArrayList<Carta> cartesFront = new ArrayList<Carta>();
   private Integer[] totalCartes = {R.drawable.c0, R.drawable.c1,
           R.drawable.c2, R.drawable.c3,
           R.drawable.c4, R.drawable.c5,
           R.drawable.c6, R.drawable.c7,
           R.drawable.c8, R.drawable.c9,
           R.drawable.c10, R.drawable.c11
   };
   private ArrayList<Carta> llistaCartes;
   private int numeroCartes;

    public Partida(Integer[] totalCartes, ArrayList<Carta> llistaCartes, int numeroCartes, ArrayList<Carta> cartesFont) {
        this.totalCartes = totalCartes;
        this.llistaCartes = llistaCartes;
        this.numeroCartes = numeroCartes;
        this.cartesFront = cartesFront;
    }

//este metodo recorre las cartas se y queda con las que estan en front
    public void devolverFront(){
        cartesFront.clear();
        for(int i = 0; i < llistaCartes.size(); i++){

            if(llistaCartes.get(i).getEstat() == Carta.Estat.FRONT){
                cartesFront.add(llistaCartes.get(i));

            }
        }
    }
    public ArrayList<Carta> getCartesFont() {
        return cartesFront;
    }

    public Partida (int numeroCartes)
    {
        this.numeroCartes = numeroCartes;
       List<Integer> llistaTotal = Arrays.asList(totalCartes);

        //TODO rellenar el ArrayList y
                
        Collections.shuffle(llistaTotal);
        llistaCartes = new ArrayList();
        for (int cont=0; cont<numeroCartes; cont++) {
            llistaCartes.add(new Carta(llistaTotal.get(cont/2)));
        }
        Collections.shuffle(llistaCartes);

    }

    public int getNumeroCartes() {
        return numeroCartes;
    }

    public ArrayList<Carta> getLlistaCartes() {
        return llistaCartes;
    }

//compara las cartas
    public boolean comprovaCartesIguals(){
        if (cartesFront.get(0) != cartesFront.get(1)){
            return true;
        }
        return false;
    }

}
