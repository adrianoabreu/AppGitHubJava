package br.com.nexas.appgithubjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.nexas.appgithubjava.adapter.RepositorioAdapter;
import br.com.nexas.appgithubjava.dto.RepositorioDTO;
import br.com.nexas.appgithubjava.modelo.Repositorio;
import br.com.nexas.appgithubjava.retrofit.RepositorioRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRepositoriosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ListView listaRepositorios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_repositorios);
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("Github JavaPop");
        setSupportActionBar(toolbar);

        listaRepositorios = (ListView) findViewById(R.id.lista_repositorios);
        // Capturando click em um item da lista.
        listaRepositorios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Repositorio repositorio = (Repositorio) listaRepositorios.getItemAtPosition(position);
                Intent intentVaiParaTelaDePullRequest = new Intent(ListaRepositoriosActivity.this, ListaPullRequestActivity.class);
                intentVaiParaTelaDePullRequest.putExtra("repositorio", repositorio);
                startActivity(intentVaiParaTelaDePullRequest);
            }
        });

        Call<RepositorioDTO> call = new RepositorioRetrofit().getRepositorioService().getRepositorio(0);
        call.enqueue(new Callback<RepositorioDTO>() {
            @Override
            public void onResponse(Call<RepositorioDTO> call, Response<RepositorioDTO> response) {
                RepositorioDTO dto = response.body();
                Log.i("onResponse chamado", "onResponse chamado com sucesso ");
                carregaLista(dto);
            }

            @Override
            public void onFailure(Call<RepositorioDTO> call, Throwable t) {
                Log.e("onFailure chamado: ", t.getMessage());
            }
        });
    }

    private void carregaLista(RepositorioDTO dto) {

        List<Repositorio> repositorios = dto.getRepositorios();
        for (Repositorio repositorio: repositorios) {
            Log.i("Nome do Rep  ", repositorio.getNomeRepositorio());
        }
        RepositorioAdapter adapter = new RepositorioAdapter(this,repositorios);
        listaRepositorios.setAdapter(adapter);
    }
}
