package com.example.consultants.week3daily1.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.consultants.week3daily1.MyDialogFragment;
import com.example.consultants.week3daily1.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnFragmentInteractionListener {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void toListFragView(View view) {
        startActivity(new Intent(getApplicationContext(), ListFragmentActivity.class));
    }
}
