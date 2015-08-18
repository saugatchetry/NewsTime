package saugat.chetry.com.newstime;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by a511863 on 18/08/15.
 */
public class MyCategoryViewHolder extends RecyclerView.ViewHolder {

    protected TextView categoryName;
    protected TextView categoryDesc;
    protected CardView card;


    public MyCategoryViewHolder(View itemView) {
        super(itemView);
        categoryName = (TextView) itemView.findViewById(R.id.subCategoryName);
        categoryDesc = (TextView) itemView.findViewById(R.id.subCategoryDesc);
        card = (CardView) itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Card","Clicked");
            }
        });

    }
}
