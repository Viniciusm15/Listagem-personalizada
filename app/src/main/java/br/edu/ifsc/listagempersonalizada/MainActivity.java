package br.edu.ifsc.listagempersonalizada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Frutas frutas = new Frutas();
        ArrayList<Fruta> listaFruta = new ArrayList();

        for (Fruta f: frutas.FRUTAS){
            listaFruta.add(f);
        }

        listView = findViewById(R.id.listView);
        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.list_item_fruit,
                listaFruta
        );
        listView.setAdapter(adapter);
    }
}
