package com.example.rifqi.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    EditText etNamePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etNamePlayer=(EditText) findViewById(R.id.name_player);

        Player player=(Player) getIntent().getSerializableExtra("player");

        etNamePlayer.setText(player.getNama_player());
    }
}
