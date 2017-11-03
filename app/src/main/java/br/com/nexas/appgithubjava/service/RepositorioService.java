package br.com.nexas.appgithubjava.service;

import br.com.nexas.appgithubjava.dto.RepositorioDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 02/11/2017.
 */

public interface RepositorioService {

    @GET("search/repositories?q=language:Java&sort=stars")
    Call<RepositorioDTO> getRepositorio(@Query("page") Integer page);

}
