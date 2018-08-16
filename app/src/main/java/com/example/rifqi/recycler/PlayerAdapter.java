package com.example.rifqi.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Player>listPlayer;

    OnClick onClick;

    public PlayerAdapter(Context context) {
        this.context = context;
        listPlayer=new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.customitem,viewGroup,false);
        return new PlayerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        PlayerViewHolder view = (PlayerViewHolder) viewHolder;
        Player player = listPlayer.get(i);

        view.txtPlayer.setText(player.getName());

        view.imgPlayer.setImageResource(player.getFoto_player());
        view.txtDesc.setText(player.getDesc_player());

        view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onClick.onClick(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPlayer;
        TextView txtPlayer;
        TextView txtDesc;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlayer = (ImageView)itemView.findViewById(R.id.img_player);
            txtPlayer=(TextView) itemView.findViewById(R.id.tv_player);
            txtDesc=(TextView) itemView.findViewById(R.id.tv_description);
        }
    }

    public void addAllPlayer(List<Player> playerList){
        for (Player player: playerList) {
            listPlayer.add(player);
        }
        notifyDataSetChanged();
    }

    public void swap(List<Player>datas)
    {
        if (datas == null || datas.size()==0)
            return;
        if (listPlayer!=null && listPlayer.size() > 0 )
            listPlayer.clear();
        listPlayer.addAll(datas);
        notifyDataSetChanged();
    }

    //detail , manual
    // di send ke main activity
    public Player getItem(int post){
        //harus public player getItem
        return listPlayer.get(post);
    }
    public interface OnClick{
        void onClick(int post);
    }
    public OnClick getOnClick() {
        return onClick;
    }
    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

}
