package com.lucas.pokedex.activity;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;

import com.lucas.pokedex.R;
import com.lucas.pokedex.fragment.PokemonBasicInfo;
import com.lucas.pokedex.model.Pokemon;

public class PokemonDetailView extends Activity implements PokemonBasicInfo.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail_view);

        if (findViewById(R.id.basic_info_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            PokemonBasicInfo basicInfo = new PokemonBasicInfo();

            Pokemon pkmn = new Pokemon();

            pkmn.setId(1);
            pkmn.setGen(1);
            pkmn.setName("Bulbasaur");
            pkmn.setNationalDexNumber(1);
            pkmn.setPokedexText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
            pkmn.setHeight(100);
            pkmn.setWeight(100);

            Bundle bundle = new Bundle();
            bundle.putSerializable(PokemonBasicInfo.ARG_PARAM1, pkmn);

            basicInfo.setArguments(bundle);

            getFragmentManager().beginTransaction().add(R.id.basic_info_container, basicInfo).commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        System.out.println("test");
    }
}
