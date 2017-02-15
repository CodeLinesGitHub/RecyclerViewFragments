package es.codelines.recyclerviewfragments;

/*import android.content.Intent;*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
/*import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;*/

import java.util.ArrayList;
/*import java.util.StringTokenizer;*/

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();


        /*ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());

        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();

            }
        });*/

    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.candy_icon, "Anahi salgado", "77779999", "anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.forest_mushroom_icon, "Pedro Sanchez", "88882222", "pedro@gmail.com"));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon, "Mireya Martinez", "33331111", "mireya@gmail.com"));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon, "Juan Lopez", "44442222", "juan@gmail.com"));
    }
}
