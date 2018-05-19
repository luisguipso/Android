package com.example.frank.crudandroidsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.frank.crudandroidsqlite.banco.DAOLancamentos;

public class TelaCadastrarAlterarLancamento extends AppCompatActivity {

    Lancamento lancamento = new Lancamento();
    EditText editTextNome;
    EditText editTextValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_alterar_lancamento);
        editTextNome = (EditText) findViewById(R.id.editNome);
        editTextValor = (EditText) findViewById(R.id.editValor);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null && bundle.containsKey("id")){
            Integer id = bundle.getInt("id");
            Log.i("Tela",""+id);
            lancamento = new DAOLancamentos(this).buscarPorId(id);
            editTextNome.setText(lancamento.getDescricao());
            editTextValor.setText(String.valueOf(lancamento.getValorLancamento()));

        }
    }

    public void inserir(View view){
        lancamento.setDescricao(editTextNome.getText().toString());
        lancamento.setValorLancamento(Double.parseDouble(editTextValor.getText().toString()));


        if(lancamento.getId()==null) {
            new DAOLancamentos(this).inserir(lancamento);
        }else{
            new DAOLancamentos(this).alterar(lancamento);
        }

        //Solução ruim
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        finish();
    }
}
