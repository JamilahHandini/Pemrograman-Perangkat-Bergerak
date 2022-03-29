package com.example.hogwartsnotes;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hogwartsnotes.databinding.ActivityMain2Binding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;


public class MainActivity2 extends DrawerBaseActivity {

    private RecyclerViewAdapter.RecyclerViewClickListener listener;
    private BottomSheetBehavior bottomSheetBehavior;

    private EditText inputText;
    private ImageButton add_note;

    String course, task, desc;
    TextView courseTxt, taskTxt, descTxt;

    ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(activityMain2Binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Fragment_Add_Task fragment_add_task = new Fragment_Add_Task();

        FragmentManager frM = getSupportFragmentManager();
        final FragmentTransaction frT = frM.beginTransaction();
        final FragmentEmpty fragmentEmpty = new FragmentEmpty();

        frT.replace(R.id.container, fragmentEmpty).commit();

        LinearLayout linearLayout = findViewById(R.id.design_bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);


        inputText=findViewById(R.id.input_title_course);
        add_note=findViewById(R.id.add_note);

        courseTxt = findViewById(R.id.cCourse);
        taskTxt = findViewById(R.id.tTask);
        descTxt = findViewById(R.id.dDesc);


        Toast.makeText(this, "main 2", Toast.LENGTH_SHORT).show();

        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
                bottomSheetBehavior.setPeekHeight(100);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Toast.makeText(MainActivity2.this, "Add Task", Toast.LENGTH_SHORT).show();
                sendData(fragment_add_task, fragmentTransaction);
            }
        });

        try {
            final String sender = this.getIntent().getExtras().getString("SENDER_KEY");
            if(sender!=null){
                bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
                bottomSheetBehavior.setPeekHeight(100);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                this.receiveData1();
                Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();
            }

            this.sendData1();
            setOnClickListener();
        }
        catch(NullPointerException e) {
            add_note.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
                    bottomSheetBehavior.setPeekHeight(100);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    Toast.makeText(MainActivity2.this, "Add Task", Toast.LENGTH_SHORT).show();
                    sendData(fragment_add_task, fragmentTransaction);
                }
            });
        }






    }

    private void setOnClickListener() {
        listener = new RecyclerViewAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                final Fragment_Add_Task fragment_add_task = new Fragment_Add_Task();
                sendData(fragment_add_task,fragmentTransaction);
            }
        };
    }

    private void receiveData1() {
        Intent i = getIntent();
        task = i.getStringExtra("Title_Task");
        desc = i.getStringExtra("Desc_Task");
        course = i.getStringExtra("From_Course");

        courseTxt.setText(course);
        taskTxt.setText(task);
        descTxt.setText(desc);
    }

    private void sendData1() {
        FragmentRecycler fr  = new FragmentRecycler();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Bundle b = new Bundle();

        b.putString("key1", courseTxt.getText().toString());
        b.putString("key2", taskTxt.getText().toString());
        b.putString("key3", descTxt.getText().toString());

        fr.setArguments(b);
        ft.replace(R.id.container, fr).commit();
    }


    private void sendData(Fragment_Add_Task f, FragmentTransaction ft){

        Bundle b = new Bundle();

        b.putString("KEY", inputText.getText().toString());

        f.setArguments(b);
        ft.replace(R.id.container, f).commit();

        Toast.makeText(MainActivity2.this, "Send Task", Toast.LENGTH_SHORT).show();
        inputText.setText("");
    }

}