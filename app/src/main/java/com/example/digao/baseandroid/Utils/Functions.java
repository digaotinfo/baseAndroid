package com.example.digao.baseandroid.Utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by digao on 04/05/16.
 */
public class Functions {
    Context mContext;
    ;
    public Functions(Context context) {
        mContext = context;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String read(String conteudo){
        String eol = System.getProperty("line.separator");
        String retorno;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(mContext.openFileInput(conteudo+".json")));){
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line + eol);
            }
            retorno = buffer.toString();
        } catch (Exception e) {
            retorno = e.getMessage();
        }
        return retorno;
    }


    public void writeFile(String response, String jsonName){
        String fileName = jsonName+".json";
        FileOutputStream outputStream = null;
        try {
            outputStream = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(response.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void consultaWebservice(String urlConteudo, final String jsonName, final Map<String, String> params){
        RequestQueue queue = Volley.newRequestQueue(mContext);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlConteudo,
                new Response.Listener<String>() {
                    @Override
                    public String onResponse(String response) {
                        writeFile(response, jsonName);

                        return response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public String onErrorResponse(VolleyError error) {
                return "erro "+error.getMessage().toString();
            }
        }) {
            @Override
            protected Map<String, String> getParams(){
                return (Map<String, String>) params;
            }
        };
        queue.add(stringRequest);//>>> ele que chama o metodo
    }
}
