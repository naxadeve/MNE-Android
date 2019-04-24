package org.odk.collect.android.mne.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import org.odk.collect.android.application.Collect;

import java.util.List;

import timber.log.Timber;


//import com.rillmark.royalworldcup.MainApplication;

public abstract class BaseFilterableRecyclerViewAdapter<L, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements Filterable {
    private List<L> l;
    private int layout;

    protected BaseFilterableRecyclerViewAdapter(List<L> l, int layout) {
        this.l = l;
        this.layout = layout;
        Timber.d("listSize = %s", l.size());
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Collect.getInstance()).inflate(layout, parent, false);
        return attachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        viewBinded(holder, l.get(position));
    }

    public List<L> getData() {
        return this.l;
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public abstract void viewBinded(VH vh, L l);

    public abstract VH attachViewHolder(View view);




}