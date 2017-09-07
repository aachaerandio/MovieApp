package com.aachaerandio.movieapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.aachaerandio.movieapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolBar();

        MoviesFragment moviesFragment = new MoviesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, moviesFragment).commit();
    }

    private void setToolBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(R.string.movie_app);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }
}
