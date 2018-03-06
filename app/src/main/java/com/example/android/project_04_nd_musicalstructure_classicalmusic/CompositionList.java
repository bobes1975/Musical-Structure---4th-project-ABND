package com.example.android.project_04_nd_musicalstructure_classicalmusic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CompositionList extends AppCompatActivity implements ListView.OnItemClickListener {

    private String mIntentMessage;
    private String mCompositionCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.composition_layout);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mIntentMessage = bundle.getString(Util.INTENT_KEY_NAME);
        }

        // Display list of compositions based on category chosen
        createCompositionList();
    }

    /**
     * Method to create list of compositions to be displayed
     */
    public void createCompositionList() {

        ArrayList<Composition> composition = new ArrayList<>();

        if (mIntentMessage.equals(getString(R.string.piano_category))) {
            // Set category
            mCompositionCategory = getString(R.string.piano_category);
            // Add composition
            composition.add(new Composition(getString(R.string.concerto1D), getString(R.string.brahmsName), getString(R.string.brahmsSurname), R.drawable.johannes_brahms));
            composition.add(new Composition(getString(R.string.concerto1E), getString(R.string.lisztName), getString(R.string.lisztSurname), R.drawable.franz_liszt));
            composition.add(new Composition(getString(R.string.rondo), getString(R.string.mozartName), getString(R.string.mozartSurname), R.drawable.wolfgang_amadeus_mozart));
            composition.add(new Composition(getString(R.string.concerto1B), getString(R.string.tchaikovskyName), getString(R.string.tchaikovskySurname), R.drawable.piotr_ilyich_tchaikovsky));
        }

        if (mIntentMessage.equals(getString(R.string.organ_category))) {
            // Set category
            mCompositionCategory = getString(R.string.organ_category);
            // Add composition
            composition.add(new Composition(getString(R.string.bwv560Gdur), getString(R.string.bachName), getString(R.string.bachSurname), R.drawable.johann_sebastian_bach));
            composition.add(new Composition(getString(R.string.bwv560Fdur), getString(R.string.bachName), getString(R.string.bachSurname), R.drawable.johann_sebastian_bach));
            composition.add(new Composition(getString(R.string.fantasia), getString(R.string.bachName), getString(R.string.bachSurname), R.drawable.johann_sebastian_bach));
            composition.add(new Composition(getString(R.string.toccataAndFugue), getString(R.string.bachName), getString(R.string.bachSurname), R.drawable.johann_sebastian_bach));
        }

        if (mIntentMessage.equals(getString(R.string.violin_category))) {
            // Set category
            mCompositionCategory = getString(R.string.violin_category);
            // Add composition
            composition.add(new Composition(getString(R.string.violinDmajor), getString(R.string.beethovenName), getString(R.string.beethovenSurname), R.drawable.ludwig_van_beethoven));
            composition.add(new Composition(getString(R.string.violinDmajor), getString(R.string.brahmsName), getString(R.string.brahmsSurname), R.drawable.johannes_brahms));
            composition.add(new Composition(getString(R.string.concerto26), getString(R.string.handelName), getString(R.string.handelSurname), R.drawable.georg_friedrich_handel));
            composition.add(new Composition(getString(R.string.violinDmajor), getString(R.string.tchaikovskyName), getString(R.string.tchaikovskySurname), R.drawable.piotr_ilyich_tchaikovsky));
            composition.add(new Composition(getString(R.string.concertoOp36), getString(R.string.tchaikovskyName), getString(R.string.tchaikovskySurname), R.drawable.piotr_ilyich_tchaikovsky));
        }

        if (mIntentMessage.equals(getString(R.string.trumpet_category))) {
            // Set category
            mCompositionCategory = getString(R.string.trumpet_category);
            // Add composition
            composition.add(new Composition(getString(R.string.concertoD), getString(R.string.telemanName), getString(R.string.telemanSurname), R.drawable.georg_philipp_telemann));
            composition.add(new Composition(getString(R.string.triumphal), getString(R.string.verdiName), getString(R.string.verdiSurname), R.drawable.giuseppe_verdi));
            composition.add(new Composition(getString(R.string.concerto2), getString(R.string.vivaldiName), getString(R.string.vivaldiSurname), R.drawable.antonio_vivaldi));
            composition.add(new Composition(getString(R.string.concertoC), getString(R.string.vivaldiName), getString(R.string.vivaldiSurname), R.drawable.antonio_vivaldi));
        }


        if (mIntentMessage.equals(getString(R.string.opera_chorus_category))) {
            // Set category
            mCompositionCategory = getString(R.string.opera_chorus_category);
            // Add composition
            composition.add(new Composition(getString(R.string.servant_chorus), getString(R.string.verdiName), getString(R.string.verdiSurname), R.drawable.giuseppe_verdi));
            composition.add(new Composition(getString(R.string.rejoice), getString(R.string.smetanaName), getString(R.string.smetanaSurname), R.drawable.bedrich_smetana));
            composition.add(new Composition(getString(R.string.gypsy_chorus), getString(R.string.verdiName), getString(R.string.verdiSurname), R.drawable.giuseppe_verdi));
            composition.add(new Composition(getString(R.string.wedding_chorus), getString(R.string.wagnerName), getString(R.string.wagnerSurname), R.drawable.richard_wagner));
            composition.add(new Composition(getString(R.string.wartburg), getString(R.string.wagnerName), getString(R.string.wagnerSurname), R.drawable.richard_wagner));
        }

        // Create an {@link CompositionAdapter}, whose data source is a list of {@link composition}s. The
        // adapter knows how to create list items for each item in the list.
        CompositionAdapter compositionAdapter = new CompositionAdapter(this, composition);

        // Find the {@link ListView} object in the view hierarchy of the {@link category_layout}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = findViewById(R.id.compositionLayout);

        // Make the {@link ListView} use the {@link CompositionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Composition} in the list.
        assert listView != null;
        listView.setAdapter(compositionAdapter);

        // Inflate header view
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.header_info, listView, false);
        TextView textHeader = headerView.findViewById(R.id.header_info);

        String headerPlaylist = getString(R.string.header_playlist1) + " " + mCompositionCategory + " " + getString(R.string.header_playlist2);

        textHeader.setText(headerPlaylist);

        // Add header view to the ListView
        listView.addHeaderView(headerView);


        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to MediaActivity
        listView.setOnItemClickListener(this);
    }

    /**
     * Method to identify ListView item clicked and launch MediaActivity
     */

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;

        String intentExtra;

        //merge composer name and composition and sent it to now.playing activity

        TextView textCompositionChosen = view.findViewById(R.id.composition);
        String compositionForPlaying = textCompositionChosen.getText().toString();

        TextView textComposerChosen = view.findViewById(R.id.composer);
        String composerForPlaying = textComposerChosen.getText().toString();

        intentExtra = composerForPlaying + "|" + compositionForPlaying;
        Intent intent = new Intent(context, NowPlaying.class);
        intent.putExtra("message", intentExtra);
        startActivity(intent);
    }
}
