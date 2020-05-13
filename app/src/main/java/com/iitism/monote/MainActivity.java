package com.iitism.monote;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.iitism.monote.db.Database;
import com.iitism.monote.db.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
   // List<User> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.note_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadRecyclerView();

        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
   public void loadRecyclerView()
   {
       class Getnote extends AsyncTask<Void,Void,List<User>>{
           @Override
           protected List<User> doInBackground(Void... voids) {
               List<User> notes= Database
                       .getInstance(getApplicationContext())
                       .userDao().getAll();
               return notes;

           }

           @Override
           protected void onPostExecute(List<User> notes) {
               super.onPostExecute(notes);
               adapter = new RecyclerViewAdapter(getApplicationContext(), notes);
               recyclerView.setAdapter(adapter);
           }
       }


     Getnote getnote=new Getnote();
       getnote.execute();




   }

}
