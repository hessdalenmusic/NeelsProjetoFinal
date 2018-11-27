package com.lourdinas.finalaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

        private String memoria;
        private String operacao;
        private double valor1 = 0;
        private double valor2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        final TextView displayConta = (TextView) findViewById(R.id.displayConta);
        final TextView displayResultado = (TextView) findViewById(R.id.displayResultado);

        final Button bt_0 = (Button) findViewById(R.id.bt_0);
        final Button bt_1 = (Button) findViewById(R.id.bt_1);
        final Button bt_2 = (Button) findViewById(R.id.bt_2);
        final Button bt_3 = (Button) findViewById(R.id.bt_3);
        final Button bt_4 = (Button) findViewById(R.id.bt_4);
        final Button bt_5 = (Button) findViewById(R.id.bt_5);
        final Button bt_6 = (Button) findViewById(R.id.bt_6);
        final Button bt_7 = (Button) findViewById(R.id.bt_7);
        final Button bt_8 = (Button) findViewById(R.id.bt_8);
        final Button bt_9 = (Button) findViewById(R.id.bt_9);
        final Button bt_soma = (Button) findViewById(R.id.bt_soma);
        final Button bt_div = (Button) findViewById(R.id.bt_div);
        final Button bt_sub = (Button) findViewById(R.id.bt_sub);
        final Button bt_mul = (Button) findViewById(R.id.bt_mul);
        final Button bt_apagar = (Button) findViewById(R.id.bt_apagar);
        final Button bt_ponto = (Button) findViewById(R.id.bt_ponto);
        final Button bt_vir = (Button) findViewById(R.id.bt_vir);
        final Button bt_igual = (Button) findViewById(R.id.bt_igual);


        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "1");
            }
        });

        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "2");
            }
        });

        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "3");
            }
        });

        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "4");
            }
        });

        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "5");
            }
        });

        bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "6");
            }
        });

        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "7");
            }
        });

        bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "8");
            }
        });

        bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "9");
            }
        });

        bt_ponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + ".");
            }
        });

        bt_apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = "";
                displayConta.setText("");
                displayResultado.setText("");
            }
        });

        bt_soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "+";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResultado.setText(displayConta.getText().toString() + "+");
                displayConta.setText("");


            }
        });

        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "-";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResultado.setText(displayConta.getText().toString()+"-");
                displayConta.setText("");
            }
        });

        bt_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "*";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResultado.setText(displayConta.getText().toString()+"*");
                displayConta.setText("");
            }
        });

        bt_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "/";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResultado.setText(displayConta.getText().toString()+"/");
                displayConta.setText("");
            }
        });

        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayConta.getText().equals("")){

                    Toast.makeText(getApplicationContext(),
                        "Digite o numero", Toast.LENGTH_LONG).show();

                } else {

                //operacao = "=";
                valor2 = Double.parseDouble(displayConta.getText().toString());
                displayConta.setText("");

                String resultado = calcular(valor1,valor2,operacao);

                displayResultado.setText(resultado);
            }
        }
        });

        }

    public String calcular(Double valor1, Double valor2, String operacao){

        Double resultado = 0.0;

        if (operacao.equals("+")){
            resultado = valor1+valor2;
        } else if (operacao.equals("-")){
            resultado = valor1-valor2;
        } else if (operacao.equals("*")){
            resultado = valor1*valor2;
        } else if (operacao.equals("/")){
            if (valor2 == 0){
                Toast.makeText(getApplicationContext(),
                "não é possivel dividir por 0",Toast.LENGTH_LONG).show();

            } else {
                resultado = valor1 / valor2;
            }
        }

        return resultado.toString();


        }
        }