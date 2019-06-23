package com.ks.task2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ks.task2.R;
import com.ks.task2.bean.DatasBean;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder>{
    private ArrayList<DatasBean> mList;

    private  boolean ischeck=true;

    public boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public ArrayList<DatasBean> getList() {
        return mList;
    }

    public void setList(ArrayList<DatasBean> list) {
        mList = list;
    }

    private Context context;

    public Myadapter(ArrayList<DatasBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final DatasBean bean = mList.get(position);
        holder.tv.setText(bean.getTitle());
        if(ischeck){
            holder.cb.setVisibility(View.GONE);
        }else {
            holder.cb.setVisibility(View.VISIBLE);
        }
      /*  holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListenerP.Onclick(position,bean,v);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private CheckBox cb;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            cb=itemView.findViewById(R.id.cb);
        }
    }
  /*  private OnClickListenerP OnClickListenerP;

    public void setOnClickListenerP(Myadapter.OnClickListenerP onClickListenerP) {
        OnClickListenerP = onClickListenerP;
    }

    public interface OnClickListenerP{
        void Onclick(int position, DatasBean bean, View view);
    }*/
}
