package com.paic.demo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import de.greenrobot.event.EventBus;


/**
 * Created by chengliangyan402 on 16/3/1.
 */
public class PostEventActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        findViewById(R.id.post_button).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MyEvent("我来自PostEventActivity post出去的事件消息"));
        finish();
    }
}
