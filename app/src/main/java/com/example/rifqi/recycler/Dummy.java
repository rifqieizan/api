package com.example.rifqi.recycler;

import java.util.ArrayList;
import java.util.List;

public class Dummy {

    public static List<Player>generatePlayer()
            //new list --> Main Activity
    {
        List<Player>listPlayer = new ArrayList<>();
            //new listplayer -> Dummy
       listPlayer.add(new Player("alerweirld",R.drawable.alderweirld,"tottenham"));
       listPlayer.add(new Player("jedrczecyk",R.drawable.jedrcz,"mainz"));
       listPlayer.add(new Player("pavlyuchenko",R.drawable.pav,"cska moskow"));
       listPlayer.add(new Player("damian plessis",R.drawable.plessis,"lens"));
       listPlayer.add(new Player("sam hutchinson",R.drawable.sam,"wigan"));
       listPlayer.add(new Player("blaszczykowski",R.drawable.blasz,"wolfsburg"));

       //player=new model
        return listPlayer;
    }
}
