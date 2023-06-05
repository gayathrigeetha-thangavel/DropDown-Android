package com.example.myappdropdown;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AlgItem> algorithmItems;
    AlgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        Spinner spinner = findViewById(R.id.spinner_algorithm);

        // we pass our item list and context to our Adapter.
        adapter = new AlgAdapter(this, algorithmItems);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id) {

                        // It returns the clicked item.
                        AlgItem clickedItem = (AlgItem)
                                parent.getItemAtPosition(position);
                        String name = clickedItem.getAlgorithmName();
                        Toast.makeText(MainActivity.this, name + " selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    // It is used to set the algorithm names to our array list.
    private void initList()
    {
        algorithmItems = new ArrayList<>();
        algorithmItems.add(new AlgItem("Quick Sort"));
        algorithmItems.add(new AlgItem("Merge Sort"));
        algorithmItems.add(new AlgItem("Heap Sort"));
        algorithmItems.add(new AlgItem("Prims Algorithm"));
        algorithmItems.add(new AlgItem("Kruskal Algorithm"));
        algorithmItems.add(new AlgItem("Rabin Karp"));
        algorithmItems.add(new AlgItem("Binary Search"));
    }
}