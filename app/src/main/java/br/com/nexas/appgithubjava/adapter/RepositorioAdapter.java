package br.com.nexas.appgithubjava.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import br.com.nexas.appgithubjava.R;
import br.com.nexas.appgithubjava.modelo.Repositorio;

/**
 * Created by user on 02/11/2017.
 */

public class RepositorioAdapter extends BaseAdapter {

    private final List<Repositorio> repositorios;
    private final Context context;

    public RepositorioAdapter(Context context, List<Repositorio> repositorios) {
        this.context = context;
        this.repositorios = repositorios;
    }

    @Override
    public int getCount() {
        return repositorios.size();
    }

    @Override
    public Object getItem(int position) {
        return repositorios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Repositorio repositorio = repositorios.get(position);

        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        if(view == null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(repositorio.getNomeSobrenome());

        TextView campoNomeRepositorio = (TextView) view.findViewById(R.id.item_nome_repositorio);
        campoNomeRepositorio.setText(repositorio.getNomeRepositorio());

        TextView campoDescricao = (TextView) view.findViewById(R.id.item_descricao);
        campoDescricao.setText(repositorio.getDescRepositorio());

        TextView campoUsername = (TextView) view.findViewById(R.id.item_username);
        campoUsername.setText(repositorio.getUsername());

        TextView campoForks = (TextView) view.findViewById(R.id.item_forks);
        campoForks.setText(repositorio.getNumeroForks());

        TextView campoStars = (TextView) view.findViewById(R.id.item_stars);
        campoStars.setText(String.valueOf(repositorio.getNumeroEstrelas()));

        SmartImageView campoFoto = (SmartImageView) view.findViewById(R.id.repositorio_image);
        Bitmap bitmap = BitmapFactory.decodeFile(repositorio.getImagemRepositorio());
        campoFoto.setImageBitmap(bitmap);
        campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        campoFoto.setImageUrl(repositorio.getImagemRepositorio());

        return view;
    }

}
