package com.example.githubassignment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.githubassignment.Models.PublicRepository;
import com.example.githubassignment.R;

import java.util.List;

public class RepositoryListAdapter  extends RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>{
    private List<PublicRepository> list;

    public RepositoryListAdapter(List<PublicRepository> list) {
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item_repos, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PublicRepository publicRepository = list.get(position);
        holder.tv_repos_name.setText(publicRepository.name);
        holder.tv_repos_id.setText(""+publicRepository.id);
        if (publicRepository.language.equalsIgnoreCase("")) {
            holder.tv_repos_language.setText("No Language Specified");
        }else {
            holder.tv_repos_language.setText(publicRepository.language);
        }
        holder.tv_watcher.setText(""+publicRepository.watchers_count);
        holder.tv_issues.setText(""+publicRepository.open_issues);

        if (publicRepository.default_branch.equalsIgnoreCase("")) {
            holder.tv_default_branch.setText("No default branch");
        }else {
            holder.tv_default_branch.setText(publicRepository.default_branch);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_repos_name;
        public TextView tv_repos_id;
        public TextView tv_repos_language;
        public TextView tv_watcher;
        public TextView tv_issues;
        public TextView tv_default_branch;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_repos_name = (TextView) itemView.findViewById(R.id.tv_repos_name);
            this.tv_repos_id = (TextView) itemView.findViewById(R.id.tv_repos_id);
            this.tv_repos_language = (TextView) itemView.findViewById(R.id.tv_repos_language);
            this.tv_watcher = (TextView) itemView.findViewById(R.id.tv_watcher);
            this.tv_issues = (TextView) itemView.findViewById(R.id.tv_issues);
            this.tv_default_branch = (TextView) itemView.findViewById(R.id.tv_default_branch);
        }
    }
}