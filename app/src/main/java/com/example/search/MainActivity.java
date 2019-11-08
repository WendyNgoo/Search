package com.example.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ListView listview;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView)findViewById(R.id.listview);
        ArrayList<String> values = new ArrayList<>();
        values.addAll(Arrays.asList(getResources().getStringArray(R.array.rooms)));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>((this),android.R.layout.simple_list_item_1,android.R.id.text1,values);
listview.setAdapter(adapter);
listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Intent intent = new Intent(view.getContext(),Main2Activity.class);
            startActivityForResult(intent,0);
        }
        if (position == 1){
            Intent intent = new Intent(view.getContext(),Main3Activity.class);
            startActivityForResult(intent,1);
        }
        if (position == 2){
            Intent intent = new Intent(view.getContext(),Main2Activity.class);
            startActivityForResult(intent,2);
        }
    }
});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search_m);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
