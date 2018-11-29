package com.lourdinas.finalaplication;

import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallFaker extends AppCompatActivity {
    String memoria = "";
    TextView t_ent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_faker);
        t_ent = findViewById(R.id.t_entrada);
        final Button bt1 = findViewById(R.id.bt_1);
        final Button bt2 = findViewById(R.id.bt_2);
        final Button bt3 = findViewById(R.id.bt_3);
        final Button bt4 = findViewById(R.id.bt_4);
        final Button bt5 = findViewById(R.id.bt_5);
        final Button bt6 = findViewById(R.id.bt_6);
        final Button bt7 = findViewById(R.id.bt_7);
        final Button bt8 = findViewById(R.id.bt_8);
        final Button bt9 = findViewById(R.id.bt_9);
        final Button bt0 = findViewById(R.id.bt_0);
        final Button bta = findViewById(R.id.bt_aster);
        final Button bth = findViewById(R.id.bt_hash);
        final Button apa = findViewById(R.id.bt_c);
        final Button ligar = findViewById(R.id.bt_ligar);

        bt0.setOnClickListener(myListener);
        bt1.setOnClickListener(myListener);
        bt3.setOnClickListener(myListener);
        bt4.setOnClickListener(myListener);
        bt5.setOnClickListener(myListener);
        bt6.setOnClickListener(myListener);
        bt7.setOnClickListener(myListener);
        bt8.setOnClickListener(myListener);
        bt9.setOnClickListener(myListener);
        bta.setOnClickListener(myListener);
        bth.setOnClickListener(myListener);
        apa.setOnClickListener(myListener);
        ligar.setOnClickListener(myListener);
    }
    private View.OnClickListener myListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_0:
                    setDisplayText("0");
                    break;
                case R.id.bt_1:
                    setDisplayText("1");
                    break;
                case R.id.bt_2:
                    setDisplayText("2");
                    break;
                case R.id.bt_3:
                    setDisplayText("3");
                    break;
                case R.id.bt_4:
                    setDisplayText("4");
                    break;
                case R.id.bt_5:
                    setDisplayText("5");
                    break;
                case R.id.bt_6:
                    setDisplayText("6");
                    break;
                case R.id.bt_7:
                    setDisplayText("7");
                    break;
                case R.id.bt_8:
                    setDisplayText("8");
                    break;
                case R.id.bt_9:
                    setDisplayText("9");
                    break;
                case R.id.bt_aster:
                    setDisplayText("*");
                    break;
                case R.id.bt_hash:
                    setDisplayText("#");
                    break;
                case R.id.bt_c:
                    if(memoria.length()>0){
                        memoria = memoria.substring( 0,memoria.length() - 1);
                        t_ent.setText(memoria);
                    }
                    break;

                case R.id.bt_ligar:

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+memoria));

                    if (ActivityCompat.checkSelfPermission(CallFaker.this,
                            Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(CallFaker.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 0);

                    }
                    startActivity(intent);


                    break;




            }
        }
    };

    private void setDisplayText(String valor) {
        memoria = memoria + valor;
        t_ent.setText(memoria);
    }
}
