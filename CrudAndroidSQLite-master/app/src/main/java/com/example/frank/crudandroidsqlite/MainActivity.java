package com.example.frank.crudandroidsqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.frank.crudandroidsqlite.banco.DAOLancamentos;

import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Lancamento lancamento = new Lancamento();
//        lancamento.setDescricao("Teste");
//        lancamento.setValorLancamento(10.);
//        lancamento.setTipoLancamento("Credito");
//        new DAOLancamentos(this).inserir(lancamento);//
//        Log.i("MainActivity",String.valueOf(new DAOLancamentos(this).consultar().size()));
        listView = findViewById(R.id.listaLancamentos);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Lancamento> listaLancamentos = new DAOLancamentos(this).consultar();
        AdapterLancamento adapterLancamento = new AdapterLancamento(this, listaLancamentos);
        listView.setAdapter(adapterLancamento);
        double saldo =0.0;
        for(Lancamento lanc: listaLancamentos){
            saldo += lanc.getValorLancamento();
        }

        TextView saldoV = findViewById(R.id.saldo);
        saldoV.setText(String.valueOf(saldo));

    }

    public void chamarTelaCadastrar(View view){
        Intent intent = new Intent(this, TelaCadastrarAlterarLancamento.class);
        startActivity(intent);
    }
    public void chamarTelaCartao(View view){
        Intent intent = new Intent(this, CadastrarCartao.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(this, TelaCadastrarAlterarLancamento.class);
            intent.putExtra("id",Integer.parseInt(String.valueOf(id)));
            startActivity(intent);
    }

    private void atualizarLista(){
        List<Lancamento> listaLancamentos = new DAOLancamentos(this).consultar();
        AdapterLancamento adapterLancamento = new AdapterLancamento(this, listaLancamentos);
        listView.setAdapter(adapterLancamento);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
         final DAOLancamentos daoLancamentos = new DAOLancamentos(this);
         final long idExcluir = id;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Excluir o Registro??")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        daoLancamentos.excluir(Integer.parseInt(String.valueOf(idExcluir)));
                        atualizarLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.show();

        return true;
    }
}
