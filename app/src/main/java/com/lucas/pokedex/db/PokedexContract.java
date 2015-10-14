package com.lucas.pokedex.db;

import android.provider.BaseColumns;

/**
 * Created by Lucas on 27/9/2015.
 */
public class PokedexContract
{

    public PokedexContract()
    {

    }

    public static abstract class PokemonEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "pokemon";
        public static final String COL_ID = "id";
        public static final String COL_NAME = "name";
        public static final String COL_GEN = "gen_id";
        public static final String COL_NAT_DEX = "nat_dex_num";
        public static final String COL_TYPE_1 = "type_1";
        public static final String COL_TYPE_2 = "type_2";
        public static final String COL_DEX_TEXT = "dex_text";
    }


}
