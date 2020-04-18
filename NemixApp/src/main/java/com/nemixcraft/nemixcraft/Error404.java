package com.nemixcraft.nemixcraft;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Error404 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error404);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_home);
                openmainactivity();
            }
        });
    }




    public void openmainactivity() {
        Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}