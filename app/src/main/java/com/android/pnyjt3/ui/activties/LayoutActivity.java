package com.android.pnyjt3.ui.activties;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.pnyjt3.R;

public class LayoutActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_vetical);

        imageView = findViewById(R.id.imageView4);

        imageView.setImageResource(R.drawable.ic_pharmacy);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeOutAnimation(imageView);
                Toast.makeText(LayoutActivity.this, "hello Image", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void fadeOutAnimation(final View viewToFadeOut) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(viewToFadeOut, "alpha", 1f, 0f);

        fadeOut.setDuration(500);
        fadeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // We wanna set the view to GONE, after it's fade out. so it actually disappear from the layout & don't take up space.
                viewToFadeOut.setVisibility(View.GONE);
            }
        });

        fadeOut.start();
    }
}