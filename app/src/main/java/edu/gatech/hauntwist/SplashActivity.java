package edu.gatech.hauntwist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SplashActivity extends AppCompatActivity {

    private EditText nameEntry;
    private Button enterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int nameAnimationDuration = 1000;
        int buttonAnimationDuration = 3000;

        nameEntry = findViewById(R.id.nameEditText);
        enterButton = findViewById(R.id.entryBttn);


        nameEntry.setAlpha(0f);
        enterButton.setAlpha(0f);

        nameEntry.animate()
                .alpha(1f)
                .setDuration(nameAnimationDuration)
                .setListener(null);

        enterButton.animate()
                .alpha(1f)
                .setDuration(buttonAnimationDuration)
                .setListener(null);

        enterButton.setOnClickListener();

    }
}
