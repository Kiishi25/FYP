package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hsalf.smilerating.SmileRating;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MoodHistoryActivity extends AppCompatActivity {
    DatabaseReference mRatingBarCh;
    FirebaseAuth fAuth;
    int feeling;
    String date;
   // ValueEventListener valueEventListener;
    ArrayList<Integer> array2; //array for mood value
    ArrayList<String> array7; //array for date
    private String TAG = "History";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mRatingBarCh = FirebaseDatabase.getInstance().getReference().child("Mood");
        fAuth = FirebaseAuth.getInstance();
        BarChart barChart = (BarChart) findViewById(R.id.chart);


        FirebaseUser rUser = fAuth.getCurrentUser();
        assert rUser != null;
        final String userId = rUser.getUid();


         mRatingBarCh =  FirebaseDatabase.getInstance().getReference("Mood").child(userId);
        mRatingBarCh.addValueEventListener (new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()) {

                   int feel = ds.child("Feel").getValue(Integer.class);
                   Log.i(TAG, "Feel" + String.valueOf(feel));


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


            // String date = " ";
                //  mRatingBarCh= FirebaseDatabase.getInstance().getReference("Mood");


                // Query query = mRatingBarCh.child("Mood").orderByChild("date").startAt("2021-03-08").endAt("2021-03-14");
//Query query1 =  FirebaseDatabase.getInstance().getReference("Mood").orderByChild("date").startAt("2021-03-08").endAt("2021-03-14");
//query1.addListenerForSingleValueEvent(valueEventListener);
//System.out.println(query1 + "q");
                //  mRatingBarCh.orderByChild("date").startAt("2021-03-08").endAt("2021-03-14");


                //    query1= (Query) dataSnapshot.child("Feel").getValue();
                // String date = (String) dataSnapshot.child("date").getValue();
                //   System.out.println("mood" + feeling + "date" + query);
                //     ArrayList<BarEntry> entries = new ArrayList<>();

                //     entries.add(new BarEntry(8f, 0));
                //   entries.add(new BarEntry(2f, 1));
                //  entries.add(new BarEntry(5f, 2));
                //   entries.add(new BarEntry(20f, 3));
                //   entries.add(new BarEntry(15f, 4));


                //   final List<String> list = new ArrayList<>();
                //    BarDataSet bardataset = new BarDataSet(entries, "Cells");


                //      ArrayList<String> labels = new ArrayList<String>();
                //      for (DataSnapshot data : dataSnapshot.getChildren()){

                //        String mood = (String) dataSnapshot.child("Feel").getValue();
                //        labels.add(mood);


                //    }
                //    labels.add("Mon");
                //     labels.add("Tue");
                //      labels.add("Wed");
                //        labels.add("Thurs");
                //    labels.add("Fri");
                //     labels.add("Sat");


                //   BarData data = new BarData(labels, bardataset);
                //    barChart.setData(data); // set the data and list of labels into chart
                //     barChart.setDescription("Set Bar Chart Description Here");  // set the description
                //      bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                //      barChart.animateY(5000);
                // date = dataSnapshot.child("moodScore").getValue().toString();
                //Toast.makeText(getApplicationContext(),date ,Toast.LENGTH_LONG).show();

            });


         }

    }


