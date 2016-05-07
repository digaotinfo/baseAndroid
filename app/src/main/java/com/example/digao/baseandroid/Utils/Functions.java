package com.example.digao.baseandroid.Utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by digao on 04/05/16.
 */
public class Functions {
    Context mContext;
    ;
    public Functions(Context context) {
        mContext = context;
    }


    public void consultaWebservice(String urlConteudo, final String jsonName, final Map<String, String> params){
        RequestQueue queue = Volley.newRequestQueue(mContext);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlConteudo,
                new Response.Listener<String>() {
                    @Override
                    public String onResponse(String response) {
                        File file = mContext.getFileStreamPath(jsonName+".json");
                        if(file.exists()){
                            try {
                                JSONObject fileLocal = new JSONObject( read(jsonName) );
                                JSONObject fileAPI = new JSONObject( response );


                                if( !fileLocal.getJSONArray(jsonName).toString().trim().equals( fileAPI.getJSONArray(jsonName).toString().trim() ) ){
                                    writeFile(fileAPI.toString(), jsonName);
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }else{
                            writeFile(response, jsonName);
                        }

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
        FileOutputStream outputStream = null;
        File dir = new File(String.valueOf(mContext.getFileStreamPath("app")));
        String fileName = jsonName+".json";

        try {
            // Create temp file.
//            File temp = File.createTempFile("TempFileName", ".tmp", mContext.getCacheDir());
//            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
//            out.write(response);
//            out.close();

            if( mContext.getFileStreamPath(fileName).exists() ){
                mContext.getFileStreamPath(fileName).delete();
            }
            outputStream = mContext.openFileOutput( fileName, Context.MODE_PRIVATE);
            outputStream.write(response.getBytes());
            outputStream.close();
        } catch (IOException e) {
            // Handle exceptions here
        }
    }
}
