package com.lucas.pokedex.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lucas.pokedex.model.Pokemon;
import com.lucas.pokedex.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 5/10/2015.
 */
public class PokemonDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PokedexDB";
    public static final String TABLE_NAME = "pokemon";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_GEN = "gen_id";
    public static final String COL_NAT_DEX = "nat_dex_num";
    public static final String COL_TYPE_1 = "type_1";
    public static final String COL_TYPE_2 = "type_2";
    public static final String COL_DEX_TEXT = "dex_text";

    private static final String[] COLUMNS = {
        COL_ID,
        COL_GEN,
        COL_NAME,
        COL_NAT_DEX,
        COL_TYPE_1,
        COL_TYPE_2,
        COL_DEX_TEXT
    };

    public PokemonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_GEN + " INTEGER, " +
                COL_NAME + " TEXT, " +
                COL_NAT_DEX + " INTEGER, " +
                COL_TYPE_1 + " INTEGER, " +
                COL_TYPE_2 + " INTEGER, " +
                COL_DEX_TEXT + " TEXT ) ";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public List<Pokemon> getAllPokemon() {
        List<Pokemon> result = new ArrayList<Pokemon>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_ID,
                null);

        if (cursor == null) {
            Log.d("getAllPokemon()", "Cursor was null");
            return result;
        }

        if (cursor.moveToFirst()) {
            do {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                pokemon.setGen(cursor.getInt(cursor.getColumnIndex(COL_GEN)));
                pokemon.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                pokemon.setNationalDexNumber(cursor.getInt(cursor.getColumnIndex(COL_NAT_DEX)));
                pokemon.setPokedexText(cursor.getString(cursor.getColumnIndex(COL_DEX_TEXT)));
                Type type1 = new Type(cursor.getInt(cursor.getColumnIndex(COL_TYPE_1)));
                pokemon.setType1(type1);
                Type type2 = new Type(cursor.getInt(cursor.getColumnIndex(COL_TYPE_2)));
                pokemon.setType2(type2);

                result.add(pokemon);
            } while (cursor.moveToNext());
        }

        return result;
    }

}
