package com.example.digao.baseandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.digao.baseandroid.Adapter.CategoriaAdapter;
import com.example.digao.baseandroid.Controller.CategoriasController;
import com.example.digao.baseandroid.Model.Categoria;
import com.example.digao.baseandroid.Utils.Constantes;
import com.example.digao.baseandroid.Utils.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoriasAct extends AppCompatActivity {

    Functions functions;
    ProgressDialog progress;
    ArrayList<Categoria> listaCat = new ArrayList<Categoria>();
    ListView lvCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias_listview_act);

        lvCategorias = (ListView)findViewById(R.id.listViewCategorias);

        progress = ProgressDialog.show(this, "",
                "Aguarde...", true);

        /////>>> seta context na function
        functions = new Functions(getApplicationContext());



        /////////////////////////////////////////////////////////////
        // SALVAR CONTENT LOCAL MANDANDO PARAMETERS >>>
        Map<String, String> params = new HashMap<String, String>();
        ////>>> parametros
//        params.put("k", "BC654654FASDFAS5465465");
//        params.put("teste", "teste de parametro");

        functions.consultaWebservice(Constantes.urlCategorias, "categorias", params);
        // <<< SALVAR CONTENT LOCAL MANDANDO PARAMETERS
        /////////////////////////////////////////////////////////////


        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onResume();

                        progress.dismiss();
                    }
                },
                1000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String lendoJSON = functions.read("categorias");

        CategoriasController categoriasController = new CategoriasController();
        ArrayList<Categoria> retornoLista = categoriasController.categoriaList(lendoJSON);

        CategoriaAdapter adpCategoria = new CategoriaAdapter(getApplicationContext(), retornoLista);
        lvCategorias.setAdapter(adpCategoria);

        //////// click listview
        lvCategorias.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String idCategoria = view.getTag().toString();

                        Intent intent = new Intent(getApplicationContext(), ConteudoAct.class);
                        intent.putExtra("idCategoria", idCategoria);

                        startActivity(intent);
                    }
                }
        );
    }

}
