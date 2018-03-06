package com.example.android.project_04_nd_musicalstructure_classicalmusic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CompositionAdapter extends ArrayAdapter<Composition> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param composition A List of composition, author and picture objects to display in a list
     */
    public CompositionAdapter(Activity context, ArrayList<Composition> composition) {
        super(context, 0, composition);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.composition_list, parent, false);
        }

        // Get the {@link Composition} object located at this position in the list
        Composition currentComposition = getItem(position);

        // Find the TextView in the composition_list.xml layout with the ID version_name
        TextView compositionTextView = listItemView.findViewById(R.id.composition);
        // Get the version name from the current object and
        // set this text on the name TextView
        assert currentComposition != null;
        compositionTextView.setText(currentComposition.getComposition());

        // Find the TextView in the composition_list.xml layout with the ID version_number
        TextView currentWholeNameTextView = listItemView.findViewById(R.id.composer);
        // Get the version number from the current object and
        // set this text on the number TextView

        String currentNameText = currentComposition.getNameComposer();
        String currentSurnameText = currentComposition.getSurnameComposer();

        String wholeName = currentNameText + " " + currentSurnameText;

        currentWholeNameTextView.setText(wholeName);

        //Find ImageView in the composition_list.xml layout with the ID version_name
        ImageView imageComposer = listItemView.findViewById(R.id.image);

        // Check if an image is provided for this composer or not
        if (currentComposition.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageComposer.setImageResource(currentComposition.getImageResourceId());
            // Make sure the view is visible
            imageComposer.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageComposer.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
