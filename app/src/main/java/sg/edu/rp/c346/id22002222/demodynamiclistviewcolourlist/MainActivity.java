package sg.edu.rp.c346.id22002222.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove,btnUpdate;
    ListView lvColour;


    ArrayList<String> alColours;

    ArrayAdapter<String> aaColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAdditem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listviewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
//                alColours.add(colour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos,colour);
                aaColour.notifyDataSetChanged();
            }
        });


        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int colour = position;
//                alColours.get(colour);
                Toast.makeText(getApplicationContext(),alColours.get(colour),Toast.LENGTH_SHORT).show();
            }
        });




    }
}