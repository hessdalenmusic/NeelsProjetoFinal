package com.lourdinas.finalaplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences meuDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        meuDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final Button login = findViewById(R.id.bt_login);
        final Button registrar = findViewById(R.id.bt_registrar);
        final EditText email = findViewById(R.id.ent_email_log);
        final EditText senha = findViewById(R.id.ent_senha_log);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meuEmail = email.getText().toString();
                String minhasenha = senha.getText().toString();

                if (meuDados.contains("email")&& meuDados.contains("senha")){

                    if(meuEmail.equals(meuDados.getString("email", ""))
                            && minhasenha.equals(meuDados.getString("senha", ""))){

                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "email ou senha invalido", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "não existe cadastros", Toast.LENGTH_LONG).show();

                }


            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Registro.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
