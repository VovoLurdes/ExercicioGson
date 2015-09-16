package br.com.teste.teste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class InformacoesActivity extends AppCompatActivity {

    private ListView listaUsuario;
    private List<Usuario> usuario;
    private static  final String USUARIO_SELECIONADO = "usuarioselecionado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);


        Intent edicao = getIntent();
        final Usuario u = (Usuario) edicao.getSerializableExtra(USUARIO_SELECIONADO);

        TextView email    = (TextView) findViewById(R.id.email);
        TextView telefone = (TextView) findViewById(R.id.telefone);
        TextView endereco = (TextView) findViewById(R.id.endereco);
        TextView site     = (TextView) findViewById(R.id.site);

        email.setText(u.getEmail());
        telefone.setText(u.getPhone());
        endereco.setText(u.getAddress().toString());
        site.setText(u.getWebsite());
        setTitle(u.getName());

        telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLigar = new Intent(Intent.ACTION_DIAL);
                intentLigar.setData(Uri.parse("tel:" + u.getPhone()));
                startActivity(intentLigar);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setType("plain/text");
                startActivity(intentEmail);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_informacoes, menu);
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
