package retrofit.simple;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

import java.util.List;

public interface GithubService {

    @GET("/retrofit/authors")
    Call<List<String>> getAuthorNames(@Query("repo_id") int repo_id);

}
