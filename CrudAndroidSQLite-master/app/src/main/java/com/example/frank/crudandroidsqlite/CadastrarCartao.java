package com.example.frank.crudandroidsqlite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.frank.crudandroidsqlite.banco.DAOCartao;

public class CadastrarCartao extends AppCompatActivity {
    EditText credito;
    Cartao cartao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cartao);
        credito = (EditText) findViewById(R.id.editTextCredito);
        cartao = new Cartao();
       /* Bundle bundle = getIntent().getExtras();
        if(bundle!=null && bundle.containsKey("id")){
            Integer id = 1;
            Log.i("Tela",""+id);
            cartao = new DAOCartao(this).buscarPorId(id);
            editTextCredito.setText(String.valueOf(cartao.getCredito()));

        }*/
    }





    public void inserir(View view){
        cartao.setCredito(Double.parseDouble(credito.getText().toString()));


        if(cartao.getId()==null) {
            new DAOCartao(this).inserir(cartao);
        }else{
            new DAOCartao(this).alterar(cartao);
        }


        finish();
    }


}
