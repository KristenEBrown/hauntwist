package edu.gatech.hauntwist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView storyIntro;
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

        storyIntro = findViewById(R.id.storyTxt);
        storyIntro.setText("Its dark... so dark you can hardly see. \n " +
                "You blink hard, attempting \n" +
                "to get your eyes to detect any glimmer \n" +
                "of light from around you. After\n" +
                "a few seconds of pitch black, you make out \n" +
                "the dim outline of furniture.\n" +
                " You seem so be in some sort of room. \n" +
                "How did you get here? You try to remember, but\n" +
                " strangely you have no memory\n" +
                "of the situation that brought to such a \n" +
                "mysterious place. In fact, the only thing \n" +
                "that you can seem to recall at all is your \n" +
                "own name... What is it?\n");
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
