package com.paic.demo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * 实验EventBus
 */
public class MainActivity extends AppCompatActivity {
    TextView tv;

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv = (TextView) findViewById(R.id.hello);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, PostEventActivity.class));
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

//    @Subscribe
//    public void onEvent(MyEvent event) {
//
//        String msg = "onEventMainThread收到了消息：" + event.getMsg();
//        Log.d("harvic", msg);
//        tv.setText(msg);
////        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }

    @Subscribe
    public void onModuleEvent(MyEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
//        Log.d("harvic", msg);
//        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
