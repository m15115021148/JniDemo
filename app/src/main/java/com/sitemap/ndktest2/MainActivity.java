package com.sitemap.ndktest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_name);
        String str = JniUtils.getStringFormC();
        String ming = "15115021148";
        String encrypmi = JniUtils.encode(ming);
        String decrypmi = JniUtils.decode(encrypmi);
        tv.setText("jni里面String是:"+str+"\n明文:"+ming+"\n加密后:"+encrypmi+"\n解密后:"+decrypmi);
    }
}
