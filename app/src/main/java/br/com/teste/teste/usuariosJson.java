package br.com.teste.teste;


import com.google.gson.Gson;

import java.util.List;

/**
 * Created by foo on 14/09/15.
 */
public class usuariosJson {

    public List<Usuario> carregarJson(String jsonString){
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(jsonString, Usuario.class);

        return usuario.getUsuarios();
    }
}
