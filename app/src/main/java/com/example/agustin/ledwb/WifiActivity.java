package com.example.agustin.ledwb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.net.*;
import java.io.*;

public class WifiActivity extends AppCompatActivity {

    RadioGroup rg;
    Button button3;
    EditText ipe ;
    EditText puert;
    public Socket sc;
    DataOutputStream mensaje;
    DataInputStream entrada;
    private Socket cliente;
    private PrintWriter printWriter;
    public Integer puerto;
    public String ip;
    Socket client;
    DataOutputStream salida;
    String color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        Intent newint = getIntent();

        //hace clin en enviar color
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipe=(EditText) findViewById(R.id.editText);
                ip=ipe.getText().toString();
                puert = (EditText) findViewById(R.id.editText2);
                puerto= Integer.parseInt(puert.getText().toString());
                rg=(RadioGroup)findViewById(R.id.radioGroup1);
                turnOnLed();
            }
        });
    }



    private void turnOnLed()
    {
        rg=(RadioGroup)findViewById(R.id.radioGroup1);
        String color = " ";
        if (rg.getCheckedRadioButtonId() == R.id.rojo) {
            color = "Rojo";
        }
        if (rg.getCheckedRadioButtonId() == R.id.verde) {
            color = "Verde";
        }
        if (rg.getCheckedRadioButtonId() == R.id.azul) {
            color = "Azul";
        }
        if (rg.getCheckedRadioButtonId() == R.id.amarillo) {
            color = "Amarillo";
        }
        if (rg.getCheckedRadioButtonId() == R.id.violeta) {
            color = "Violeta";
        }
        if (rg.getCheckedRadioButtonId() == R.id.celeste){
            color = "Celeste";

        }
        if (rg.getCheckedRadioButtonId()== R.id.ninguno){
            color = "Ninguno";

        }

        Toast.makeText(getApplicationContext(), "Color Seleccionado: " + color, Toast.LENGTH_LONG).show();
        final String finalColor = color;

        new Thread(new Runnable() {
            @Override
            public void run() {
               Socket miSocket;
                DataOutputStream out;
                try{
                    miSocket = new Socket(ip,puerto);
                    out = new DataOutputStream(miSocket.getOutputStream());
                    out.writeUTF(finalColor);
                    out.close();;
                    miSocket.close();

                }catch (Exception ex){

                }

               /* try {
                    //creamos server socket
                    client = new Socket("192.168.0.107", 8600);
                    if (client.isConnected()) {
                        //Toast.makeText(getApplicationContext(), "conexion con : " + client.getLocalPort(), Toast.LENGTH_LONG).show();

                        printWriter = new PrintWriter(client.getOutputStream());
                        printWriter.write(finalColor);
                        printWriter.flush();
                        printWriter.close();
                        client.close();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error de conexion: ", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }
        }).start();
    }

}
