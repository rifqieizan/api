package com.example.rifqi.recycler;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPlayer;
    PlayerAdapter adapter;
    List<Player> players = new ArrayList<>();
    //players=new list array dummy <-> main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPlayer = (RecyclerView)findViewById(R.id.list_show);
        adapter = new PlayerAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewPlayer.setLayoutManager(linearLayoutManager);
        recyclerViewPlayer.setAdapter(adapter);
        loadPlayer();
//
//        players = Dummy.generatePlayer();
//        //inisialisi list & mengambil dari data dummy
//        adapter.addAllPlayer(players);
//        //mengambil data adapter dari PlayerAdapter & method addAllplayer
//
//        adapter.setOnClick(new PlayerAdapter.OnClick() {
//         //new PlayerAdapter.OnClick
//            @Override
//            public void onClick(int post) {
//
////                Intent i = new Intent(MainActivity.this, DetailActivity.class);
////                Bundle data = new Bundle();
////
////                data.putSerializable("player",adapter.getItem(post));
////
////                i.putExtras(data);
////                startActivity(i);
//                detailDetails(adapter.getItem(post));
//            }
//        });
    }

    public void loadPlayer()
    {
        AndroidNetworking.get("http://localhost/API1/public/api/players")
                .build()
                .getAsObject(PlayerResponds.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        if (response instanceof PlayerResponds){
                            adapter.swap( ((PlayerResponds) response).getData() );
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void detailDetails(Player player)
    {
        BlankFragment blank=BlankFragment.newInstance(player);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(android.R.id.content,blank).addToBackStack(null).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    }

}
