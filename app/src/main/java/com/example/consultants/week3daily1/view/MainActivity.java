package com.example.consultants.week3daily1.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.consultants.week3daily1.fragment.MyDialogFragment;
import com.example.consultants.week3daily1.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnFragmentInteractionListener {


    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    public void showDialog(View view) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder1,
                        MyDialogFragment.newInstance("msg1", "msg2"),
                        MyDialogFragment.TAG)
                .addToBackStack(MyDialogFragment.TAG)
                .commit();

        //uses timer to keep fragment displayed for 3 seconds
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                //finds the fragment so we can remove it
                MyDialogFragment myDialogFragment = (MyDialogFragment) getSupportFragmentManager().
                        findFragmentByTag(MyDialogFragment.TAG);
                getSupportFragmentManager().beginTransaction().remove(myDialogFragment).commit();

                t.cancel(); // stops the timer at the end
            }
        }, 3000); //delays for 3000ms, or 3 seconds

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void toListFragView(View view) {
        startActivity(new Intent(getApplicationContext(), ListFragmentActivity.class));
    }

}
