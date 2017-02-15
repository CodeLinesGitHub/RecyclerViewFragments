package es.codelines.recyclerviewfragments;

/*import android.content.Intent;*/
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
/*import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;*/

import java.util.ArrayList;

import es.codelines.recyclerviewfragments.adapter.ContactoAdaptador;
import es.codelines.recyclerviewfragments.adapter.PageAdapter;
import es.codelines.recyclerviewfragments.fragment.PerfilFragment;
import es.codelines.recyclerviewfragments.fragment.RecyclerViewFragment;
import es.codelines.recyclerviewfragments.pojo.Contacto;
/*import java.util.StringTokenizer;*/

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        /*rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        rvContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();*/

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        rvContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.candy_icon, "Anahi salgado", "77779999", "anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.forest_mushroom_icon, "Pedro Sanchez", "88882222", "pedro@gmail.com"));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon, "Mireya Martinez", "33331111", "mireya@gmail.com"));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon, "Juan Lopez", "44442222", "juan@gmail.com"));
    }
}
