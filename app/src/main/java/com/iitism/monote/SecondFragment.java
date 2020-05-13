package com.iitism.monote;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.iitism.monote.db.Database;
import com.iitism.monote.db.DatabaseApplication;
import com.iitism.monote.db.User;
import com.iitism.monote.db.UserDao;

public class SecondFragment extends Fragment {
    EditText edt_title;
    EditText edt_note;

    //private User user;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_second, container, false);
        edt_title=view.findViewById(R.id.edt_text_title);
        edt_note=view.findViewById(R.id.edt_text_note);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               saveNote();

            }
        });
    }
    private void saveNote()
    {
       final String title;
       final String note;
        title=edt_title.getText().toString().trim();
        note=edt_note.getText().toString().trim();

        class saveNote extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected Void doInBackground(Void... voids) {
                final User user=new User();
                user.setTitle(title);
                user.setNote(note);
                Database.getInstance(getContext()).userDao().insertUser(user);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getContext(),"Successfully added ",Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        }


        if(title.isEmpty() || note.isEmpty())
        {
            Toast.makeText(getContext(),"The field(s) cannot be empty ",Toast.LENGTH_LONG).show();
        }
        else
        {
           saveNote saveNote=new saveNote();
           saveNote.execute();
        }


    }
}
