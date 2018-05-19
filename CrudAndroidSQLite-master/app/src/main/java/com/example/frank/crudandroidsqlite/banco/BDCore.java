package com.example.frank.crudandroidsqlite.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aluno on 20/04/18.
 */

public class BDCore extends SQLiteOpenHelper{
    private final static String NOME_BANCO="financeiro";
    private final static Integer VERSAO_BANCO=1;

    public BDCore(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table lancamentos(id integer primary key " +
                "autoincrement, " +
                "descricao varchar(200),"+
                "valor real);");
        db.execSQL("create table cartao(id integer primary key,"+
                "credito real," +
                "vencimento text," +
                "fechamento text);");
        db.execSQL("create table fatura(id integer primary key " +
                "autoincrement, "+
                "vencimento text," +
                "id_cartao integer,"+
                "fechamento text,"+
                "foreign key(id_cartao"+") references cartao("+"id));");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table lancamentos");
        db.execSQL("drop table cartao");
        db.execSQL("drop table fatura");
        onCreate(db);
    }
}
