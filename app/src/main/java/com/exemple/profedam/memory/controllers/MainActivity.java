package com.exemple.profedam.memory.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.exemple.profedam.memory.R;

/**
 * Created by ALUMNEDAM on 23/11/2016.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private Button primero, segundo, tercero;
    public int numCart;
    public final int REQUEST_CODE = 560;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAceptar = (Button) findViewById(R.id.guardar);
        btnAceptar.setOnClickListener(this);



    }

    public int getNumCart() {
        return numCart;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.guardar){
            RadioGroup grupo = (RadioGroup) findViewById(R.id.grupobtn);
            final Intent intent = new Intent(this, MuestraCartas.class);
        // comprueba cual de los checkbox a sido seleccionado
            switch(grupo.getCheckedRadioButtonId()) {
                case R.id.checkBox:
                    numCart = 6;
                    intent.putExtra("numCart",numCart);
                    break;
                case R.id.checkBox2:
                    numCart = 12;
                    intent.putExtra("numCart",numCart);
                    break;
                case R.id.checkBox3:
                    numCart = 24;
                    intent.putExtra("numCart",numCart);
                    break;
            }
            //envia cual ha sido seleccionado a MuestraCartas
            startActivity(intent);

        }

    }


}