package com.example.sacha.tiposdecafes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sacha on 21/09/2017.
 */

public class NewActivity extends Activity {
    TextView mensaje;
    //private Button buttonCancelar;
    //public final static String EXTRA_MESSAGE2 = "com.example.sacha.tiposdecafes.MESSAGE2";
    public static final int REQUEST_CODE2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        mensaje = (TextView)findViewById(R.id.textViewNew);

        //Pour obtenir le message de Intent
        Intent intent = getIntent();
        String mens = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mensaje.setText(mens);

    }//onCreate

    public void cancelar(View view){
        String cancelado = "Pedido cancelado";
        Intent intent = new Intent();
        intent.putExtra("EXTRA_MESSAGE2",cancelado);
        setResult(MainActivity.RESULT_OK,intent);
        finish();

    }

    public void acceptar(View view){
       String acceptado = "Pedido acceptado";
        Intent intent = new Intent();
        intent.putExtra("EXTRA_MESSAGE2",acceptado);
        setResult(MainActivity.RESULT_OK,intent);
        finish();


    }

   /* String textToPedido(){

    }*/
}//class
