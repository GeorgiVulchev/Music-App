package com.example.musicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Song> songsList;

    public SongListAdapter(Context context, int layout, ArrayList<Song> songsList) {
        this.context = context;
        this.layout = layout;
        this.songsList = songsList;
    }

    @Override
    public int getCount() {
        return songsList.size();
    }

    @Override
    public Object getItem(int position) {
        return songsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName =  row.findViewById(R.id.txtName);
            holder.imageView =  row.findViewById(R.id.imgSong);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Song song = songsList.get(position);

        holder.txtName.setText(song.getName());

        byte[] songImage = song.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(songImage, 0, songImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}