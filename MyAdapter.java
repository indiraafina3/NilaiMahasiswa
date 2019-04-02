package com.dicoding.picodiploma.nilaimahasiswa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MViewHolder> {

    ArrayList<String> ids;
    ArrayList<Pojo> values;

    public MyAdapter(ArrayList<String> ids, ArrayList<Pojo> values){
        this.ids = ids;
        this.values = values;
    }

    @NonNull
    @Override
    public MyAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup, false);

        return new MViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MViewHolder mViewHolder, int i) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference ref = db.getReference().child("mahasiswa");

        final Pojo p = values.get(i);

        mViewHolder.tv1.setText(ids.get(i));
        mViewHolder.tv2.setText(p.getNama());
        mViewHolder.tv3.setText(p.getJurusan());
        mViewHolder.tv4.setText(p.getHuruf());
        mViewHolder.tv5.setText(String.valueOf(p.getTotal()));



    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder {

        // Deklarasi View/Widget
        TextView tv1, tv2, tv3, tv4, tv5;
//        Button bUpd, bDel;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            // Hubungkan View/Widget
            tv1= (TextView) itemView.findViewById(R.id.tv1);
            tv2= (TextView) itemView.findViewById(R.id.tv2);
            tv3= (TextView) itemView.findViewById(R.id.tv3);
            tv4= (TextView) itemView.findViewById(R.id.tv4);
            tv5= (TextView) itemView.findViewById(R.id.tv5);
//            bUpd= (Button) itemView.findViewById(R.id.btnUpdate);
//            bDel= (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
