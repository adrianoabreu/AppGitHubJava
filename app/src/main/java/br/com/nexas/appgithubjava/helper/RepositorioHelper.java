package br.com.nexas.appgithubjava.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import br.com.nexas.appgithubjava.ListaPullRequestActivity;
import br.com.nexas.appgithubjava.R;
import br.com.nexas.appgithubjava.modelo.Repositorio;

/**
 * Created by user on 02/11/2017.
 */

public class RepositorioHelper {

    private final TextView campoNome;
    private final TextView  campoNomeRepositorio;
    private final TextView  campoDescricao;
    private final TextView  campoStars;
    private final TextView  campoForks;
    private final TextView  campoUsername;
    private final SmartImageView campoFoto;
    private Repositorio repositorio;

    public RepositorioHelper(ListaPullRequestActivity activity){

        // pegando parâmetros do activity_formulario.xml;
        campoNome = (TextView) activity.findViewById(R.id.item_nome);
        campoNomeRepositorio = (TextView) activity.findViewById(R.id.item_nome_repositorio);
        campoDescricao = (TextView) activity.findViewById(R.id.item_descricao);
        campoStars = (TextView) activity.findViewById(R.id.item_stars);
        campoForks = (TextView) activity.findViewById(R.id.item_forks);
        campoUsername = (TextView) activity.findViewById(R.id.item_username);
        campoFoto = (SmartImageView) activity.findViewById(R.id.repositorio_image);
        repositorio = new Repositorio();
    }

    public void preencheInfo(Repositorio rep) {

        campoNome.setText(rep.getNomeSobrenome());
        campoDescricao.setText(rep.getDescRepositorio());
        campoStars.setText(String.valueOf(rep.getNumeroEstrelas()));
        campoForks.setText(String.valueOf(rep.getNumeroEstrelas()));
        campoNomeRepositorio.setText(rep.getNomeRepositorio());
        campoUsername.setText(rep.getUsername());

        Bitmap bitmap = BitmapFactory.decodeFile(rep.getImagemRepositorio());
        campoFoto.setImageBitmap(bitmap);
        campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        campoFoto.setImageUrl(rep.getImagemRepositorio());
        this.repositorio = rep;

    }
}
