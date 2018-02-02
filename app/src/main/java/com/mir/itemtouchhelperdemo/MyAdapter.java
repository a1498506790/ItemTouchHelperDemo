package com.mir.itemtouchhelperdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2018/2/2
 * @desc
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemMoveListener{

    private Context mContext;
    private List<String> mList;
    private ItemDragListener mItemDragListener;

    public MyAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mItemDragListener = (ItemDragListener) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rlv_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
        holder.mTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mItemDragListener.onStartDrags(holder);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //交换数据
        Collections.swap(mList, fromPosition, toPosition);
        //刷新
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txt);
        }
    }

}
