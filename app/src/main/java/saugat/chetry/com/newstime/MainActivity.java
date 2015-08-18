package saugat.chetry.com.newstime;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    String url = "http://fierce-mesa-1366.herokuapp.com/";
    ProgressDialog dialog;
    ArrayList<InternetData> data = new ArrayList<>();
    ArrayList<Categories> dataFromAPI;
    private ExpandableListView ExpandList;
    private ExpandListAdapter ExpAdapter;

    RecyclerView recyclerView;
    LinearLayoutManager linearLM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
   /*     recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
        linearLM = new LinearLayoutManager(MainActivity.this);
        linearLM.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLM);*/



        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(MainActivity.this,"Downloading...",Toast.LENGTH_SHORT).show();
                        //Log.d("Response",""+response);
                        dialog.dismiss();
                        parseTheFeed(response);
                        dataFromAPI = createDataToShow(response);

                        ExpAdapter = new ExpandListAdapter(MainActivity.this, dataFromAPI);
                        ExpandList.setAdapter(ExpAdapter);
                        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
                        LinearLayoutManager linearLM = new LinearLayoutManager(MainActivity.this);
                        linearLM.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(linearLM);*/

                        //recyclerView.setAdapter(new MyCategoryAdapter(data));

                        //showTheData(data);
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Log.d("Network","Error :- "+error);
            }
        });

        requestQueue.add(request);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Downloading");
        dialog.setMessage("Please Wait ....");
        dialog.show();
    }

    public ArrayList<Categories> createDataToShow(String str)
    {
        ArrayList<Categories> list = new ArrayList<>();
        ArrayList<SubCategories> subList;


        try
        {
            JSONArray jsonArray = new JSONArray(str);
            for(int i = 0;i < jsonArray.length();i++)
            {
                Categories cat = new Categories();
                JSONObject currentObject = jsonArray.getJSONObject(i);

                String categoryName = currentObject.getString("CategoryName");
                cat.setCategoryName(categoryName);

                int categoryId = currentObject.getInt("CategoryId");
                cat.setCategoryId(categoryId);

                String categoryImageUrl = currentObject.getString("ImageUrl");
                cat.setCategoryImageUrl(categoryImageUrl);

                subList = new ArrayList<>();
                JSONArray subCategoryArray = currentObject.getJSONArray("Subcategories");

                for(int j = 0; j < subCategoryArray.length(); j++)
                {
                    SubCategories subCat = new SubCategories();

                    JSONObject currentSubCategoryObject = subCategoryArray.getJSONObject(j);

                    int subCategoryId = currentSubCategoryObject.getInt("subCategoryId");
                    String  subCategoryName = currentSubCategoryObject.getString("subCategoryName");
                    String subCategoryImageUrl = currentSubCategoryObject.getString("ImageUrl");
                    String subCategoryDescription = currentSubCategoryObject.getString("description");

                    subCat.setSubCategoryId(subCategoryId);
                    subCat.setSubCategoryName(subCategoryName);
                    subCat.setSubCategoryDescription(subCategoryDescription);
                    subCat.setSubCategoryImageUrl(subCategoryImageUrl);

                    subList.add(subCat);

                }

                cat.setSubCategoriesArrayList(subList);
                list.add(cat);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }


    public void parseTheFeed(String str)
    {
        try {
                JSONArray jsonArray = new JSONArray(str);
                for(int i = 0;i < jsonArray.length();i++)
                {
                    InternetData internetData = new InternetData();
                    JSONObject currentObject = jsonArray.getJSONObject(i);

                    String categoryName = currentObject.getString("CategoryName");
                    internetData.setCategoryName(categoryName);

                    int categoryId = currentObject.getInt("CategoryId");
                    internetData.setCategoryId(categoryId);

                    String categoryImageUrl = currentObject.getString("ImageUrl");
                    internetData.setCategoryImageUrl(categoryImageUrl);

                    JSONArray subCategoryArray = currentObject.getJSONArray("Subcategories");
                    int[] subCategoryIds = new int[3];
                    //String[][] subCategoryDatas = new String[3][3];
                    String[] subcatnames = new String[3];
                    String[] subcatImageUrls = new String[3];
                    String[] subcatDesc = new String[3];

                    for(int j = 0; j < subCategoryArray.length(); j++)
                    {
                        JSONObject currentSubCategoryObject = subCategoryArray.getJSONObject(j);

                        String  subCategoryName = currentSubCategoryObject.getString("subCategoryName");
                        //internetData.setSubCategoryName(subCategoryName);
                        //subCategoryDatas[j][0] = subCategoryName;
                        subcatnames[j] = subCategoryName;

                        int subCategoryId = currentSubCategoryObject.getInt("subCategoryId");
                        //internetData.setSubCategoryId(subCategoryId);
                        subCategoryIds[j] = subCategoryId;

                        String subCategoryImageUrl = currentSubCategoryObject.getString("ImageUrl");
                        //internetData.setSubCategoryImageUrl(subCategoryImageUrl);
                        //subCategoryDatas[j][1] = subCategoryImageUrl;
                        subcatImageUrls[j] = subCategoryImageUrl;

                        String subCategoryDescription = currentSubCategoryObject.getString("description");
                        //internetData.setSubCategoryDescription(subCategoryDescription);
                        //subCategoryDatas[j][2] = subCategoryDescription;
                        subcatDesc[j] = subCategoryDescription;
                        //internetData.setSubCategoryData(subCategoryDatas);

                    }
                    internetData.setSubCategoryIds(subCategoryIds);
                    internetData.setSubCategoryNames(subcatnames);
                    internetData.setSubCategoryImageUrls(subcatImageUrls);
                    internetData.setSubCategoryDescriptions(subcatDesc);

                    data.add(internetData);

                    //Log.d("Length"," "+data.size());
                    //Log.d("Subcategories","Length = "+subCategoryArray.length());
                    //Log.d("SubCatNames",""+subcatnames[3]);
                    //Log.d("Items","Name = "+categoryName+" Id = "+categoryId);
                }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showTheData(ArrayList<InternetData> internetKaData)
    {
        for(int i = 0; i < internetKaData.size();i++)
        {
            String[] subNames = new String[3];
            String[] subImgUrls = new String[3];
            String[] subDesc = new String[3];
            subNames = internetKaData.get(i).getSubCategoryNames();
            subImgUrls = internetKaData.get(i).getSubCategoryImageUrls();
            subDesc = internetKaData.get(i).getSubCategoryDescriptions();
            for(int j = 0;j<subNames.length;j++) {
                Log.d("Data", "SubCategory at "+i+" Name :- " + subNames[j]);
                Log.d("Data", "SubCategory at "+i+" ImageUrl :- " + subImgUrls[j]);
                Log.d("Data", "SubCategory at "+i+" Name :- " + subDesc[j]);
            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
