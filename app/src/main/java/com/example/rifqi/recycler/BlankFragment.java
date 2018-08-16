package com.example.rifqi.recycler;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @BindView(R.id.img_player)
    ImageView imgPlayer;
    @BindView(R.id.tv_fragment)
    TextView tvFragment;
    @BindView(R.id.tv2_fragment)
    TextView tv2Fragment;
    Unbinder unbinder;

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(Player player) {

        Bundle args = new Bundle();
        //1
        args.putSerializable("player", player);

        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, view);

        //2
        Player player=(Player) getArguments().getSerializable("player");
        //3
        imgPlayer.setImageResource(player.getFoto_player());
        tvFragment.setText(player.getNama_player());
        tv2Fragment.setText(player.getDesc_player());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
