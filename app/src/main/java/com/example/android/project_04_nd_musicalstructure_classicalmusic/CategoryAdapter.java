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


public class CategoryAdapter extends ArrayAdapter<Category> {

    CategoryAdapter(Activity context, ArrayList<Category> category) {
        super(context, 0, category);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.category_list, parent, false);
        }

        // Get the {@link Category} object located at this position in the list
        Category currentCategory = getItem(position);

        // Find the TextView in the category_list.xml layout with the ID category
        TextView categoryTextView = listItemView.findViewById(R.id.category);
        // Get the category from the current object and
        // set this text on the name TextView
        assert currentCategory != null;
        categoryTextView.setText(currentCategory.getNameCategory());


        //Find ImageView in the category_list.xml layout with the ID version_name
        ImageView imageComposer = listItemView.findViewById(R.id.image);

        // Check if an image is provided for this category or not
        if (currentCategory.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageComposer.setImageResource(currentCategory.getImageResourceId());
            // Make sure the view is visible
            imageComposer.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageComposer.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing ! TextView and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

