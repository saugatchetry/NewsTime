package saugat.chetry.com.newstime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by a511863 on 18/08/15.
 */
public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryViewHolder> {

    private ArrayList<InternetData> data;
    public MyCategoryAdapter(ArrayList<InternetData> internetKaData)
    {
        this.data = new ArrayList<>();
        this.data.addAll(internetKaData);

    }
    @Override
    public MyCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.category_cards, parent, false);

        return new MyCategoryViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyCategoryViewHolder holder, int position) {

        InternetData id = data.get(position);
        holder.categoryName.setText(id.getCategoryName());
        holder.categoryDesc.setText("Description");



    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
