package edu.gatech.hauntwist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashActivity extends AppCompatActivity {

    private EditText nameEntry;
    private Button enterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        createAttributes();



    }

    private void createAttributes() {
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

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter();
            }});
    }

    private void enter() {

        HouseMap.setTheMap(new HouseMap());

        boolean locationChosen = false;
        int counter = 0;
        RoomTile start = null;
        while (!locationChosen) {
            RoomTile room = HouseMap.getTheMap().getRoomList().get(counter);
            Log.d("DEBUG", "" + room.isConnected());
            if (room.isConnected()) {
                start = room;
                locationChosen = true;
            } else {
                counter++;
            }

        }

        User.setCurrentUser(new User(start, nameEntry.getText().toString()));

        startActivity(new Intent(SplashActivity.this, DisplayActivity.class));


        }

}
