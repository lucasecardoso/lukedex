package com.lucas.pokedex.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.lucas.pokedex.R;
import com.lucas.pokedex.fragment.PokemonBasicInfo;
import com.lucas.pokedex.model.Pokemon;

public class PokemonDetailView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail_view);

        if (findViewById(R.id.basic_info_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            PokemonBasicInfo basicInfo = new PokemonBasicInfo();

            Fragment fragment = new Fragment();

            Pokemon pkmn = new Pokemon();

            pkmn.setId(1);
            pkmn.setGen(1);
            pkmn.setName("Bulbasaur");
            pkmn.setNationalDexNumber(1);
            pkmn.setPokedexText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

            Bundle bundle = new Bundle();
            bundle.putSerializable(PokemonBasicInfo.ARG_PARAM1, pkmn);

            basicInfo.setArguments(bundle);

            getFragmentManager().beginTransaction().add(R.id.basic_info_container, basicInfo).commit();
        }

    }
}
