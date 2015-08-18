package saugat.chetry.com.newstime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by a511863 on 18/08/15.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private ArrayList<Categories> categorieses;
    private ImageLoader mImageLoader;


    public ExpandListAdapter(Context context,ArrayList<Categories> categorieses)
    {
        this.mImageLoader = VolleySingleton.getInstance().getImageLoader();
        this.context = context;
        this.categorieses = categorieses;
    }
    @Override
    public int getGroupCount() {
        return categorieses.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<SubCategories> chList = categorieses.get(groupPosition).getSubCategoriesArrayList();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categorieses.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        ArrayList<SubCategories> chList = categorieses.get(groupPosition).getSubCategoriesArrayList();
        return chList.get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        Categories group = (Categories) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.category_items, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.category_name);
        final ImageView iv = (ImageView) convertView.findViewById(R.id.category_image);
        tv.setText(group.getCategoryName());

        String urlThumnail = group.getCategoryImageUrl().toString();

        mImageLoader.get(urlThumnail, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                iv.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                iv.setBackgroundResource(R.mipmap.ic_launcher);
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)
    {
        SubCategories subCat = (SubCategories) getChild(groupPosition, childPosition);
        if(convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.subcategory_items, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.subcategory_name);
        final ImageView iv = (ImageView) convertView.findViewById(R.id.subcategory_image);

        tv.setText(subCat.getSubCategoryName().toString());

        String urlThumnail = subCat.getSubCategoryImageUrl().toString();
        mImageLoader.get(urlThumnail,new ImageLoader.ImageListener(){

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                iv.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                iv.setBackgroundResource(R.mipmap.ic_launcher);
            }
        });

        //tv.setText(subCat.getSubCategoryImageUrl().toString());
        //iv.setImageResource(subCat.getSubCategoryImageUrl());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
