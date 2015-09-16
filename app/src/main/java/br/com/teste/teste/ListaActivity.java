package br.com.teste.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.util.List;


public class ListaActivity extends AppCompatActivity {

    private ListView listaUsuario;
    private List<Usuario> usuario;
    public static final String URL="https://dl.dropboxusercontent.com/u/1337551/users.json";
    Adapter dataAdapter;
    Gson gson;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listaUsuario = (ListView) findViewById(R.id.lista_usuarios);
        client = new AsyncHttpClient();
        client.get(ListaActivity.this, URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String urlestr = new String(responseBody);
                Log.i("bla", urlestr);
                Type collectionType = new TypeToken<List<Usuario>>() {
                }.getType();
                gson = new Gson();
                usuario = gson.fromJson(urlestr, collectionType);
                dataAdapter = new Adapter(ListaActivity.this, usuario);
                listaUsuario.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        listaUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent edicao = new Intent(
                        ListaActivity.this,
                        InformacoesActivity.class);

                Usuario selecionado = (Usuario) parent.getItemAtPosition(position);
                edicao.putExtra("usuarioselecionado",selecionado);
                startActivity(edicao);

            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
