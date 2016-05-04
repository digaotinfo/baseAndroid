package com.example.digao.baseandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.digao.baseandroid.Adapter.ConteudoAdapter;
import com.example.digao.baseandroid.Controller.CategoriasController;
import com.example.digao.baseandroid.Controller.ConteudoController;
import com.example.digao.baseandroid.Model.Categoria;
import com.example.digao.baseandroid.Model.Conteudo;
import com.example.digao.baseandroid.Utils.Constantes;
import com.example.digao.baseandroid.Utils.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConteudoAct extends AppCompatActivity {

    String idCategoria;
    Functions functions;
    ProgressDialog progress;
    ListView listViewConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_listview);

        listViewConteudo = (ListView)findViewById(R.id.listViewConteudo);

        Bundle b = getIntent().getExtras();
        idCategoria = b.get("idCategoria").toString();

        progress = ProgressDialog.show(this, "",
                "Aguarde...", true);

        /////>>> seta context na function
        functions = new Functions(getApplicationContext());

        /////////////////////////////////////////////////////////////
        // SALVAR CONTENT LOCAL MANDANDO PARAMETERS >>>
        Map<String, String> params = new HashMap<String, String>();
        ////>>> parametros
        //params.put("k", "BC654654FASDFAS5465465");
        //params.put("teste", "teste de parametro");

        functions.consultaWebservice(Constantes.urlConteudo, "conteudo", params);
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
        ////// setar nome da categoria no topo do app >>>
        String lendoJSON = functions.read("categorias");

        CategoriasController categoriasController = new CategoriasController();
        Categoria retornoLista = categoriasController.categoria(lendoJSON, idCategoria);

        setTitle(retornoLista.getCategoria_ptbr().toString());
        ////// <<< setar nome da categoria no topo do app





        ////// Pegar lista desta categoria >>>
        String lendoJSONConteudo = functions.read("conteudo");

        ConteudoController conteudoController = new ConteudoController();
        ArrayList<Conteudo> retornoListaConteudo = conteudoController.conteudoList(lendoJSONConteudo, idCategoria);

        ConteudoAdapter adpConteudo = new ConteudoAdapter(getApplicationContext(), retornoListaConteudo);
        listViewConteudo.setAdapter(adpConteudo);
        ////// <<< Pegar lista desta categoria
    }

}
