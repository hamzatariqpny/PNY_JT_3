package com.android.pnyjt3.ui.activties;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.pnyjt3.R;
import com.android.pnyjt3.model.Movie;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    Activity activity;
    ArrayList<Movie> movies;

    ArrayList<String> imgs = new ArrayList<>();

    public MoviesAdapter(Activity activity, ArrayList<Movie> movies) {
        this.activity = activity;
        this.movies = movies;
        loadImages();

    }

    // Handle all the views
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = activity.getLayoutInflater().inflate(R.layout.row_movies,parent,false);
        return new MoviesViewHolder(view);

    }

    // Handle data to be place on the view
    // this method gets called as many time as getItemCount is passed
    // position is the counter for Recycler view 0,1,2,3,4,5,6,7..10
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, final int position) {

        Movie movie = movies.get(position);

        holder.movieName.setText( movie.getMovieName());
        holder.movieRatting.setText("ratting : "+movie.getMovieRatting());

        Glide.with(holder.itemView).load(imgs.get(position)).into(holder.movieImage);

    }

    // Tells you how many items to display on screen
    @Override
    public int getItemCount() {
        return movies.size();
    }

     class MoviesViewHolder extends RecyclerView.ViewHolder{

        ImageView movieImage;
        TextView movieName;
        TextView movieRatting;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movieImage);
            movieName = itemView.findViewById(R.id.movieName);
            movieRatting = itemView.findViewById(R.id.movieRatting);

        }
    }


    public void loadImages(){
        imgs.add("https://img.freepik.com/free-psd/banner-template-design-with-business-team_23-2148438466.jpg?size=626&ext=jpg");
        imgs.add("https://i.ytimg.com/vi/1zBar4PKwws/maxresdefault.jpg");
        imgs.add("https://img.freepik.com/free-vector/set-banners-with-photos_23-2148437152.jpg?size=626&ext=jpg");
        imgs.add("https://www.circleone.in/images/products_gallery_images/Event-Banners86.jpg");
    }




}
