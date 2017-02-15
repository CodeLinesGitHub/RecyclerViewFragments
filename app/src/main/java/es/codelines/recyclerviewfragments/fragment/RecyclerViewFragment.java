package es.codelines.recyclerviewfragments.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.codelines.recyclerviewfragments.R;
import es.codelines.recyclerviewfragments.adapter.ContactoAdaptador;
import es.codelines.recyclerviewfragments.pojo.Contacto;

/**
 * Created by abraham on 15/2/17.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        rvContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();

        return v;

    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.candy_icon, "Anahi salgado", "77779999", "anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.forest_mushroom_icon, "Pedro Sanchez", "88882222", "pedro@gmail.com"));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon, "Mireya Martinez", "33331111", "mireya@gmail.com"));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon, "Juan Lopez", "44442222", "juan@gmail.com"));
    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        rvContactos.setAdapter(adaptador);
    }
}
