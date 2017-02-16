package edu.grinnell.appdev.grinnelldirectory.Activity;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import edu.grinnell.appdev.grinnelldirectory.Interfaces.DatabaseAPI;
import edu.grinnell.appdev.grinnelldirectory.Model.Person;
import edu.grinnell.appdev.grinnelldirectory.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nicholasroberson on 2/15/17.
 */

public class APICaller {

    private String baseUrl = "https://itwebappstest.grinnell.edu/DotNet/WebServices/api/";
    private Retrofit retrofit;
    private DatabaseAPI dbAPI;
    private Call<List<Person>> personQuery;
    private User user;

    public APICaller() {
        retrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        dbAPI = retrofit.create(DatabaseAPI.class);
        user = new User("test1stu", "selfserv1");
    }

    public List<Person> simpleSearch(User user, List<String> fields) {
        personQuery = dbAPI.simpleSearch(user, "Nicholas", "Roberson", "", "");

        personQuery.enqueue(new Callback<List<Person>>() {

            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.body() != null) {
                    Log.d("API_SUCCESS", "API returned list of people.");
                    // response.body() is the list of people, set to 'people'
                    List<Person> people = response.body();
                } else {
                    try {
                        Log.e("ERROR", response.errorBody().string());
                    } catch (IOException e) {
                        Log.e("API_FAILURE_EXCEPTION", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.e("API_FAILURE", t.toString());
            }
        });
    }
}

/*
Make simpleSearch, advancedSearch, and authenticateUser functions for both.

New interface: serverResponse, serverError, connectionError.
 */