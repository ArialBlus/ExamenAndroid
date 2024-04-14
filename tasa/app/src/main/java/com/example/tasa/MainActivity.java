package com.example.tasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView num1;
    private TextView resul;

    private String seleccionActual = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.num1);
        resul=findViewById(R.id.resul);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutasa, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();

        if(id==R.id.dolar){
            seleccionActual = "dolar";

        } else if (id==R.id.cordoba) {
            seleccionActual="cordoba";

        }

        return super.onOptionsItemSelected(item);
    }

    public void calcular(View view)
    {
        String stringnum=num1.getText().toString();
        int intnum=Integer.parseInt(stringnum);

        if(seleccionActual=="dolar"){
            int resulto=intnum*37;
            String resultado=String.valueOf(resulto);

            resul.setText(resultado);
        } else if (seleccionActual=="cordoba") {
            int resulto=intnum/37;
            String resultado=String.valueOf(resulto);

            resul.setText(resultado);

        }


    }
}