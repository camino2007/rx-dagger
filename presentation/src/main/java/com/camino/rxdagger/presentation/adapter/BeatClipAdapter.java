package com.camino.rxdagger.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camino.data.model.BeatClip;
import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.adapter.holder.BeatClipHolder;
import com.camino.rxdagger.presentation.adapter.holder.FooterLoadHolder;
import com.camino.rxdagger.presentation.internal.di.PerActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rxdroid on 2/28/16.
 */
@PerActivity
public class BeatClipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_CONTENT = 0;
    private static final int VIEW_TYPE_FOOTER = 1;

    private List<BeatClipWrapper> mBeatClipWrappers = new ArrayList<>();

    @Inject
    public BeatClipAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_TYPE_CONTENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beatclip, parent, false);
            viewHolder = new BeatClipHolder(parent.getContext(), view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer_load, parent, false);
            viewHolder = new FooterLoadHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final BeatClipWrapper wrapperItem = mBeatClipWrappers.get(position);
        if (getItemViewType(position) == VIEW_TYPE_CONTENT) {
            BeatClipHolder beatClipHolder = (BeatClipHolder) holder;
            BeatClip beatClip = wrapperItem.getBeatClip();
            beatClipHolder.bind(beatClip);
        } else {
            FooterLoadHolder footerHolder = (FooterLoadHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return mBeatClipWrappers.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (mBeatClipWrappers.get(position).isFooter()) {
            return VIEW_TYPE_FOOTER;
        } else {
            return VIEW_TYPE_CONTENT;
        }
    }

    public void addItem(int position, BeatClipWrapper beatClipWrapper) {
        mBeatClipWrappers.add(position, beatClipWrapper);
        notifyItemInserted(mBeatClipWrappers.size());
    }

    public void addItems(List<BeatClipWrapper> beatClipWrappers) {
        int index = mBeatClipWrappers.size();
        for (BeatClipWrapper beatClipWrapper : beatClipWrappers) {
            addItem(index, beatClipWrapper);
            index++;
        }
    }

    public void updateItem(int position, BeatClipWrapper beatClipWrapper) {
        mBeatClipWrappers.set(position, beatClipWrapper);
        notifyItemChanged(position);
    }

    public void removeItem(int position) {
        if (position >= 0 && position < mBeatClipWrappers.size()) {
            mBeatClipWrappers.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clearAdapter() {
        mBeatClipWrappers.clear();
        notifyDataSetChanged();
    }
}
