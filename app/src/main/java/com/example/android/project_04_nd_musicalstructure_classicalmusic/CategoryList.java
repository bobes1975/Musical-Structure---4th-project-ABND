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

public class CategoryList extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);
        // Create an array of categories

        final ArrayList<Category> category = new ArrayList<>();

        category.add(new Category(getString(R.string.piano_category), R.drawable.piano));
        category.add(new Category(getString(R.string.organ_category), R.drawable.organ));
        category.add(new Category(getString(R.string.violin_category), R.drawable.violin));
        category.add(new Category(getString(R.string.trumpet_category), R.drawable.trumpet));
        category.add(new Category(getString(R.string.opera_chorus_category), R.drawable.opera_choir));

        // Create an {@link CategoryAdapter}, whose data source is a list of {@link category}s. The
        // adapter knows how to create list items for each item in the list.
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, category);

        // Find the {@link ListView} object in the view hierarchy of the {@link category_layout}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // category_list.xml file.
        ListView listView = findViewById(R.id.categoryLayout);

        // Make the {@link ListView} use the {@link CategoryAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Category} in the list.
        assert listView != null;
        listView.setAdapter(categoryAdapter);

        // Inflate header info
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.header_info, listView, false);
        TextView textHeader = headerView.findViewById(R.id.header_info);
        textHeader.setText(getString(R.string.header_category));

        // Add header view to the ListView
        listView.addHeaderView(headerView);

        // ListView setOnItemClickListener function apply here.
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Context context = this;

        //This method identifies ListView item clicked and launches proper CompositionList

        TextView textView = view.findViewById(R.id.category);
        String categoryText = textView.getText().toString();

        Intent intent = new Intent(context, CompositionList.class);
        intent.putExtra("message", categoryText);
        startActivity(intent);
    }
}



