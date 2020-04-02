package com.app.mobilize.Presentador.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mobilize.Model.Usuari;
import com.app.mobilize.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterUsuarios extends RecyclerView.Adapter<AdapterUsuarios.viewholderusuarios> {

    private List<Usuari> userList;

    public AdapterUsuarios(List<Usuari> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public viewholderusuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_usuarios, parent,false);
        return new viewholderusuarios(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderusuarios holder, int position) {
        Usuari us = userList.get(position);
        holder.username.setText(us.getUsername());
        Glide.with(holder.itemView).load(Uri.parse(us.getImage())).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class viewholderusuarios extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView username;

        viewholderusuarios(@NonNull View itemView) {
            super(itemView);

            username = (TextView) itemView.findViewById(R.id.busquedaUserTV);
            avatar = (ImageView) itemView.findViewById(R.id.AvatarIV_Cercador);

        }
    }
}
