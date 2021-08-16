package com.example.petime;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.petime.databinding.FragmentItemBinding;
import com.example.petime.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 * 社交页面的adapter
 */
public class MySocietyItemRecyclerViewAdapter extends RecyclerView.Adapter<MySocietyItemRecyclerViewAdapter.ViewHolder> {

    private final List<SocietyData> mValues;

    public MySocietyItemRecyclerViewAdapter(List<SocietyData> items) {
        //把数据源传进来，并赋给变量mValues
        mValues = items;
    }
//由于Adapter是继承的，所以要重写以下三个方法
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//创建view—holder实例
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //对子项赋值😘
        SocietyData mItem=mValues.get(position);
        //holder.mItem = mValues.get(position);
        holder.mIdView.setText(mItem.getId());
        holder.mContentView.setText(mItem.getName());
    }

    @Override
    public int getItemCount() {
        //返回实例长度
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // 获取我们的实例
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}