package com.yuhdeveloper.dizibulmaca;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.myViewHolder> {


    public Context c;
    List<String> lstSeriesName;
    List<Integer> lstSeriesImage;

    public RecyAdapter(Context _c, List<String> _lstSeriesName, List<Integer> _lstSeriesImage) {
        c = _c;
        lstSeriesImage = _lstSeriesImage;
        lstSeriesName = _lstSeriesName;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.custom_recy,parent,false);

        return new myViewHolder(view,c);
    }

    @Override
    public int getItemCount() {
        return lstSeriesImage.size();
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.setData(lstSeriesImage.get(position),lstSeriesName.get(position),position);
    }

    public static class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        Context c;
        int pos;
        public myViewHolder(View itemView, Context _c) {
            super(itemView);
            textView = itemView.findViewById(R.id.custom_recyTextView);
            imageView = itemView.findViewById(R.id.custom_recyImageView);
            imageView.setOnClickListener(this);
            c = _c;
        }


        void setData(Integer image, String name, int position){
            textView.setText(name);
            imageView.setImageResource(image);
            pos = position;
        }

        @Override
        public void onClick(View v) {
            if(pos<5){

            Intent intent = new Intent(c,MainActivity.class);
            intent.putExtra("chooseSeries",pos);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(intent);

            }else{
                Toast.makeText(c, "Yakında !!!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}