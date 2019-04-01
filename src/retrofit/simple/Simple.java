package retrofit.simple;

import retrofit.Retrofit;

public class Simple {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit();
        GithubService githubService = retrofit.build(GithubService.class);

        int repo_id = 123;
        githubService.getAuthorNames(repo_id);
    }

}
