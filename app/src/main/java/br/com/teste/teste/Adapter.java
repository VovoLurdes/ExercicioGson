package br.com.teste.teste;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by foo on 15/09/15.
 */
public class Adapter extends BaseAdapter {

    private List<Usuario> usuario;
    private Activity activity;
    private LayoutInflater mInflater;
    private ViewHolder holder;

    public Adapter(Activity activity, List<Usuario> usuario) {
        this.activity = activity;
        this.usuario = usuario;
    }


    @Override
    public int getCount() { return this.usuario.size();}

    @Override
    public Object getItem(int position) { return this.usuario.get(position); }

    @Override
    public long getItemId(int position) { return this.usuario.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.itens,parent, false);
        Usuario u = (Usuario) getItem(position);

        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView email = (TextView) rowView.findViewById(R.id.email);

        name.setText(u.getName());
        email.setText(u.getEmail());

        return rowView;
    }

    static class ViewHolder{
        TextView name;
        TextView email;
    }
}
