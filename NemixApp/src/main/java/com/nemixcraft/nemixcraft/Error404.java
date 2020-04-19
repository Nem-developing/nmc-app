package com.nemixcraft.nemixcraft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Error404 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error404);

        configureNextButton();
}
    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.button_switch);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Error404.this, MainActivity.class));
            }
        });
    }
}
