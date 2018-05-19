package com.example.frank.crudandroidsqlite.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.frank.crudandroidsqlite.Cartao;
import com.example.frank.crudandroidsqlite.Lancamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 18/05/18.
 */

public class DAOCartao {
    SQLiteDatabase database;

    public DAOCartao(Context context){
        database = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Cartao cartao){
        ContentValues values = new ContentValues();

        values.put("id",0);
        values.put("credito",cartao.getCredito());
        database.insert("cartao", null, values);
    }
    public void excluir(Integer id){
        database.delete("cartao","id=?",
                new String[]{String.valueOf(id)});

        //database.delete("cartao","id="+id,null);
    }
    public void alterar(Cartao cartao){
        ContentValues values = new ContentValues();
        values.put("credito",cartao.getCredito());
        database.update("cartao",values,
                "id=0",null);
    }
    public List<Cartao> consultar(){
        List<Cartao> cartoes = new ArrayList<>();
        String[] colunas = {"id", "credito"};
        Cursor cursor = database.query("cartao", colunas,
                null,null,null,null,
                null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount(); x++){
            Cartao cartao = new Cartao();
            cartao.setId(cursor.getInt(0));
            cartao.setCredito(cursor.getDouble(1));
            cartoes.add(cartao);
            cursor.moveToNext();
        }
        return cartoes;
    }

    public Cartao buscarPorId(Integer id){
        Cartao cartao = new Cartao();
        String[] colunas = {"id", "credito"};
        Cursor cursor = database.query("cartao", colunas,
                "id="+id,null,null,null,
                null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cartao.setId(cursor.getInt(0));
            cartao.setCredito(cursor.getDouble(1));
        }
        return cartao;
    }
}
