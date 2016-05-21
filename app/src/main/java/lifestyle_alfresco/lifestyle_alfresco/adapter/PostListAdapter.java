package lifestyle_alfresco.lifestyle_alfresco.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lifestyle_alfresco.lifestyle_alfresco.R;
import lifestyle_alfresco.lifestyle_alfresco.dto.PostDTO;


public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.RemindViewHolder> {

    private List<PostDTO> data;

    public PostListAdapter(List<PostDTO> data) {
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);

        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        PostDTO item = data.get(position);
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<PostDTO> data) {
        this.data = data;
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        public RemindViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

}