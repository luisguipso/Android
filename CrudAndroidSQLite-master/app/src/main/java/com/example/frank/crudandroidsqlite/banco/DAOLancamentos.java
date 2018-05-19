package com.example.frank.crudandroidsqlite.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.frank.crudandroidsqlite.Lancamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 20/04/18.
 */

public class DAOLancamentos {

    SQLiteDatabase database;

    public DAOLancamentos(Context context){
        database = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Lancamento lancamento){
        Log.i("DAOLancamentos",lancamento.getDescricao());
        ContentValues values = new ContentValues();
        values.put("descricao",lancamento.getDescricao());
        values.put("valor", lancamento.getValorLancamento());
        database.insert("lancamentos", null, values);
    }
    public void excluir(Integer id){
        database.delete("lancamentos","id=?",
                new String[]{String.valueOf(id)});

        //database.delete("lancamentos","id="+id,null);
    }
    public void alterar(Lancamento lancamento){
        ContentValues values = new ContentValues();
        values.put("descricao",lancamento.getDescricao());
        values.put("valor", lancamento.getValorLancamento());
        database.update("lancamentos",values,
                "id="+lancamento.getId(),null);
    }
    public List<Lancamento> consultar(){
        List<Lancamento> lancamentos = new ArrayList<>();
        String[] colunas = {"id", "descricao", "valor"};
        Cursor cursor = database.query("lancamentos", colunas,
                null,null,null,null,
                null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount(); x++){
            Lancamento lancamento = new Lancamento();
            lancamento.setId(cursor.getInt(0));
            lancamento.setDescricao(cursor.getString(1));
            lancamento.setValorLancamento(cursor.getDouble(2));
            lancamentos.add(lancamento);
            cursor.moveToNext();
        }
        return lancamentos;
    }

    public Lancamento buscarPorId(Integer id){
        Lancamento lancamento = new Lancamento();
        String[] colunas = {"id", "descricao", "tipo_lancamento", "valor"};
        Cursor cursor = database.query("lancamentos", colunas,
                "id="+id,null,null,null,
                null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            lancamento.setId(cursor.getInt(0));
            lancamento.setDescricao(cursor.getString(1));
            lancamento.setValorLancamento(cursor.getDouble(2));
        }
        return lancamento;
    }

}
