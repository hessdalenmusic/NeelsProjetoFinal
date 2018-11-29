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

import static com.lourdinas.finalaplication.Login.mypreference;

public class Registro extends AppCompatActivity {

    SharedPreferences meuDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        meuDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final EditText novoEmail = findViewById(R.id.ent_emailcad);
        final EditText senha = findViewById(R.id.ent_senhacad);
        final EditText confimarsenha = findViewById(R.id.ent_senhacad2);
        Button cadastrar = findViewById(R.id.bt_cad_cadastrar);



        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (senha.getText().toString().equals(confimarsenha.getText().toString())){

                    SharedPreferences.Editor editor = meuDados.edit();
                    editor.putString("email", novoEmail.getText().toString());
                    editor.putString("senha", senha.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(),
                            "dados salvos com sucesso", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Registro.this, Login.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "as senhas não conferem", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
