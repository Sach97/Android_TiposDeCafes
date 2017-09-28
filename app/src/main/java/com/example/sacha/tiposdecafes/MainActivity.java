package com.example.sacha.tiposdecafes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //static final int ACCEPTED = 0;
    //Que es MESSAGE? Donde viene ?
    public static final int REQUEST_CODE = 1;
    public final static String EXTRA_MESSAGE = "com.example.sacha.tiposdecafes.MESSAGE";

    private CheckBox checkCrema;
    private CheckBox checkAzucar;

    private RadioButton cafeDescafeinado;
    private RadioButton cafeExpresso;
    private RadioButton cafeSolidario;

    private Button buttonBuscar;

    String textToCafe(){
        String cadena = "Pedido: cafe";

        if(cafeDescafeinado.isChecked()){
            cadena += "Descafeinado";
        } else if(cafeExpresso.isChecked()){
            cadena += "Expresso";
        }else if(cafeSolidario.isChecked()){
            cadena += "Solidario";
        }

        if(checkAzucar.isChecked()){
            cadena +=" con azucar";
        }else{
            cadena += "";
        }

        if(checkCrema.isChecked()){
            cadena +=" y crema de leche";
        }else{
            cadena += "";
        }
        return cadena;
    }//textToCafe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCrema = (CheckBox) findViewById(R.id.checkCrema);
        checkAzucar = (CheckBox) findViewById(R.id.checkAzucar);
        cafeDescafeinado = (RadioButton) findViewById(R.id.cafeDescafeinado);
        cafeExpresso = (RadioButton) findViewById(R.id.cafeExpresso);
        cafeSolidario = (RadioButton) findViewById(R.id.cafeSolidario);

        buttonBuscar = (Button) findViewById(R.id.buttonBuscar);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUriString ="http://www.google.com/#q=" + "cafe";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
                startActivity(intent);
            }
        });

    }//onCreate

    //Mene à newActivity après avoir appuyé sur le bouton pagar
    public void pagar(View view){
        Intent intent = new Intent(this,NewActivity.class);
        intent.putExtra(EXTRA_MESSAGE,textToCafe());
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE){
            if(resultCode== NewActivity.RESULT_OK){
               String result = data.getStringExtra("EXTRA_MESSAGE2");
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            }
           /* if(){

            }*/
        }
    }//OnActivityResult
}
