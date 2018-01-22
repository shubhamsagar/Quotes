package com.shubham.quotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener ,View.OnTouchListener{

    GridView grid;
    BottomNavigationView navigation;
    Intent j;
    static RecyclerView recyclerView;
    static RecyclerView.Adapter adapter;
    static List<ListItem> listItems;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_dashboard:
                    Intent intent = new Intent(getApplicationContext(),favourite.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    Intent intentl = new Intent(getApplicationContext(),about_us.class);
                    startActivity(intentl);
                    return true;
                case R.id.navigation_share:
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,
                            "Hey check out this amazing quotes app: https://play.google.com/store/apps/details?id=com.shubham.quotes");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                    return true;
            }
            return false;
        }
    };

    private ImageView Selection;
    private static final Integer[] items =
            { R.drawable.architecture,
            R.drawable.art, R.drawable.birthday, R.drawable.business,
            R.drawable.car, R.drawable.christmas,
            R.drawable.cool,R.drawable.dating,
            R.drawable.death,R.drawable.environment,
                    R.drawable.fathersday,
            R.drawable.fear,R.drawable.finance,
            R.drawable.food,R.drawable.forgiveness,
                    R.drawable.friendship,
            R.drawable.future,R.drawable.god,
            R.drawable.hope, R.drawable.house,
                    R.drawable.inspiration,R.drawable.intelligence,
                    R.drawable.learning,R.drawable.legal,
                    R.drawable.love,
                    R.drawable.leadership,R.drawable.memorial,
                    R.drawable.money,
                    R.drawable.mother,R.drawable.music,
                    R.drawable.nature,
                    R.drawable.newyear,
                    R.drawable.patience,
                    R.drawable.pet,R.drawable.poetry,
                    R.drawable.politics,R.drawable.power,
                    R.drawable.program,
                    R.drawable.relationship,R.drawable.sad,
                    R.drawable.science,R.drawable.smile,
                    R.drawable.teacher,
                    R.drawable.time,R.drawable.travel,
                    R.drawable.trust,R.drawable.truth,
                    R.drawable.valentinesday
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Selection = (ImageView) findViewById(R.id.selection);
         grid = (GridView) findViewById(R.id.grid);
        // grid.setAdapter(new ArrayAdapter<Integer>(this, R.layout.cell,
        // items));
        grid.setAdapter(new CustomGridAdapter(this, items));
        grid.setOnItemClickListener(this);
        grid.setOnScrollListener(onScrollListener());



    }

  private AbsListView.OnScrollListener onScrollListener()
  {
      return  new AbsListView.OnScrollListener() {

          @Override
          public void onScrollStateChanged(AbsListView absListView, int i)
          {

          }
          @Override
          public void onScroll(AbsListView absListView, int i, int i1, int i2)
          {

              if(i == 0)
              {
                  View v = grid.getChildAt(0);

                  int offset = (v ==null)?0: v.getTop();
                  if (offset == 0)
                  {
                      Log.i("Top","top reached");
                      navigation.setVisibility(View.VISIBLE);
                  }

              }
              /*else if(i2 - i1 == i)
              {
                  View v  = grid.getChildAt(i2-1);
                  int offset = (v == null)?0: v.getTop();
                  if (offset == 0)
                  {
                      Log.i("Bottom","bottom reached");
                      navigation.setVisibility(View.VISIBLE);
                  }
              }*/
              else if (i2 - i1>i)
              {
                  Log.i("Scroll","on scroll");
                  navigation.setVisibility(View.GONE);
              }
          }
      };
  }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        if ( i == 0)
        {
            String type ="architecture";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 1)
        {
            String type ="art";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        } else if ( i == 2)
        {
            String type ="birthday";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 3)
        {
            String type ="business";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }else if ( i == 4)
        {
            String type ="car";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 5)
        {
            String type ="christmas";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 6)
        {
            String type ="cool";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 7)
        {
            String type ="dating";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 8)
        {
            String type ="death";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 9)
        {
            String type ="environment";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 10)
        {
            String type ="fathersday";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 11)
        {
            String type ="fear";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 12)
        {
            String type ="finance";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 13)
        {
            String type ="food";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 14)
        {
            String type ="forgiveness";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 15)
        {
            String type ="friendship";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 16)
        {
            String type ="future";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 17)
        {
            String type ="god";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 18)
        {
            String type ="hope";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 19)
        {
            String type ="home";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 20)
        {
            String type ="inspirational";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 21)
        {
            String type ="intelligence";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 22)
        {
            String type ="learning";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 23)
        {
            String type ="legal";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 24)
        {
            String type ="love";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 25)
        {
            String type ="leadership";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else if ( i == 26)
        {
            String type ="memorial";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 27)
        {
            String type ="money";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 28)
        {
            String type ="mothersday";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 29)
        {
            String type ="music";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 30)
        {
            String type ="nature";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 31)
        {
            String type ="newyears";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 32)
        {
            String type ="patience";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 33)
        {
            String type ="pet";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 34)
        {
            String type ="poetry";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else   if ( i == 35)
        {
            String type ="politics";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 36)
        {
            String type ="power";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 37)
        {
            String type ="programming";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 38)
        {
            String type ="relationship";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 39)
        {
            String type ="sad";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 40)
        {
            String type ="science";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 41)
        {
            String type ="smile";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 42)
        {
            String type ="teacher";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 43)
        {
            String type ="time";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 44)
        {
            String type ="travel";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 45)
        {
            String type ="trust";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 46)
        {
            String type ="truth";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }
        else  if ( i == 47)
        {
            String type ="valentinesday";
            j = new Intent(getApplicationContext(),generatequote.class);
            j.putExtra("category",type);
            startActivity(j);
        }

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {

        return false;

    }

    public class CustomGridAdapter extends BaseAdapter {
        private Activity mContext;

        // Keep all Images in array
        public Integer[] mThumbIds;

        // Constructor
        public CustomGridAdapter(MainActivity mainActivity, Integer[] items) {
            this.mContext = mainActivity;
            this.mThumbIds = items;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Nullable
        @Override
        public CharSequence[] getAutofillOptions() {
            return new CharSequence[0];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            return imageView;
        }
    }

}
