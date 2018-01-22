package com.shubham.quotes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class generatequote extends AppCompatActivity
{
    TextView textView;
    String quote ,author,category,type;
    Button button;
    DatabaseHandler db;
    DilatingDotsProgressBar dilatingDotsProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatequote);
        dilatingDotsProgressBar = (DilatingDotsProgressBar)findViewById(R.id.progress);
        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("category");
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.quote);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                loadRecyclerdata();
            }
        });
            loadRecyclerdata();
        db = new DatabaseHandler(this);
    }

    public  void loadRecyclerdata() {

        dilatingDotsProgressBar.showNow();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,"https://quotes.p.mashape.com/?category="+type,new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                dilatingDotsProgressBar.hideNow();
                try
                {
                     JSONObject jsonObject = new JSONObject(response);
                     Log.d("Data","Success!"+jsonObject);
                     quote = jsonObject.getString("quote");
                     author = jsonObject.getString("author");
                     category = jsonObject.getString("category");
                     textView.setText(quote);
                     for (int i =0 ; i <= 0   ; i++)
                     {
                         db.addContact(new Contact(i, quote, author, category));
                     }
                }
                catch (JSONException e)
                {
                       e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        }
        )
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-Mashape-Key", "19Em73Eo66msh6rIuMKBw7ZZ5jjvp1YxvDmjsnbESQCJR9ZPnV");
                headers.put("Accept", "application/json");
                return headers;
            }
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                return super.parseNetworkError(volleyError);
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
