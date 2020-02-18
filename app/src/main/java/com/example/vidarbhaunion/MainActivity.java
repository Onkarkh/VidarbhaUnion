package com.example.vidarbhaunion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import com.example.vidarbhaunion.home.Home;
import com.example.vidarbhaunion.loadingImage.LoadingImage;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.mainFrame);

        loadingImage();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadHomeFragment();
            }
        }, 3000);
    }

    private void loadingImage() {
        Fragment loadingImage = new LoadingImage();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, loadingImage).commit();
    }

    private void loadHomeFragment() {
        Fragment homePage = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, homePage).commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        loadHomeFragment();
    }
}
