package com.nemixcraft.nemixcraft;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ForumActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        //WebView
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.nemixcraft.com/community");


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        //Initialise
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.forum);

        //Perform ItemSelectedListener


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.staff:
                        if (isConnected()) {
                            startActivity(new Intent(getApplicationContext(), StaffActivity.class));
                            overridePendingTransition(0, 0);

                        } else {
                            Toast.makeText(getApplicationContext(), "Vous n'avez pas de connection :(", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Error404.class));
                            overridePendingTransition(0, 0);
                        }
                        return true;

                    case R.id.reglement:
                        if (isConnected()) {
                            startActivity(new Intent(getApplicationContext(), ReglementActivity.class));
                            overridePendingTransition(0, 0);

                        } else {
                            Toast.makeText(getApplicationContext(), "Vous n'avez pas de connection :(", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Error404.class));
                            overridePendingTransition(0, 0);
                        }
                        return true;
                    case R.id.home:
                        if (isConnected()) {
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            overridePendingTransition(0, 0);

                        } else {
                            Toast.makeText(getApplicationContext(), "Vous n'avez pas de connection :(", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Error404.class));
                            overridePendingTransition(0, 0);
                        }
                        return true;
                    case R.id.forum:
                        return true;
                    case R.id.statistiques:
                        if (isConnected()) {
                            startActivity(new Intent(getApplicationContext(), StatistiquesActivity.class));
                            overridePendingTransition(0, 0);

                        } else {
                            Toast.makeText(getApplicationContext(), "Vous n'avez pas de connection :(", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Error404.class));
                            overridePendingTransition(0, 0);
                        }
                        return true;
                }


                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
}