package com.android.pnyjt3.ui.activties;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pnyjt3.R;
import com.android.pnyjt3.model.ErrorHandler;
import com.android.pnyjt3.model.Movie;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonActivity extends AppCompatActivity {

    ArrayList<Movie> movies = new ArrayList<>();
    String url = "https://tutorialscache.com/movies.json";

    RequestQueue requestQueue;
    ProgressBar progress_circular;

    RecyclerView moviesRV;

    MoviesAdapter moviesAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        moviesRV = findViewById(R.id.moviesRV);
        progress_circular = findViewById(R.id.progress_circular);

        moviesRV.setLayoutManager(new LinearLayoutManager(this));


        requestQueue = Volley.newRequestQueue(this);

        getAllMovies();
    }

    public void getAllMovies() {
        // API CALL

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progress_circular.setVisibility(View.GONE);
                parseJSON(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = ErrorHandler.getErrorMessage(error);
                Toast.makeText(JsonActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }


    public void postRequest(){


        StringRequest stringRequest =  new StringRequest(Request.Method.POST, "https://jsonplaceholder.typicode.com/posts",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(JsonActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = ErrorHandler.getErrorMessage(error);
                Toast.makeText(JsonActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("title","this is a cool title");
                params.put("body","this is the body");
                params.put("userId","1");

                return params;
            }
        };


        requestQueue.add(stringRequest);
    }

    // { JSON object
    // [  JSON Array

    public void parseJSON(String response) {

        try {
            JSONObject apiResponseObj = new JSONObject(response);

            boolean status = apiResponseObj.optBoolean("status", false);

            if (status) {

                JSONArray moviesArray = apiResponseObj.getJSONArray("movies");

                for (int i = 0; i < moviesArray.length(); i++) {

                    JSONObject movieObj = moviesArray.getJSONObject(i);

                    Movie movie = new Movie();
                    movie.setId(movieObj.optInt("id", 0));
                    movie.setMovieName(movieObj.optString("name", ""));
                    movie.setImageUrl(movieObj.optString("image", ""));
                    movie.setMovieRatting(movieObj.optString("ratting", ""));

                    movies.add(movie);

                }

                moviesAdapter = new MoviesAdapter(this,movies);

                moviesRV.setAdapter(moviesAdapter);

            } else {
                Toast.makeText(this, "Error Response", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}