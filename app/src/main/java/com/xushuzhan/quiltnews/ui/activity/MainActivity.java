package com.xushuzhan.quiltnews.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.xushuzhan.quiltnews.R;
import com.xushuzhan.quiltnews.ui.fragment.bottom.BeforeBedNewsFragment;
import com.xushuzhan.quiltnews.ui.fragment.bottom.EyeshotNewsFragment;
import com.xushuzhan.quiltnews.ui.fragment.bottom.HotNewsFragment;
import com.xushuzhan.quiltnews.ui.fragment.bottom.PersonalCenterFragment;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    RadioGroup radioGroup;
    FragmentManager fragmentManager;
    ImageButton ReadMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        transaction1.replace(R.id.content, new HotNewsFragment());
        transaction1.commit();
        radioGroup = (RadioGroup) findViewById(R.id.tab);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.bottom_hot_news:
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.content, new HotNewsFragment());
                        transaction.commit();
                        break;
                    case R.id.bottom_eyeshot_news:
                        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                        transaction1.replace(R.id.content, new EyeshotNewsFragment());
                        transaction1.commit();
                        break;
                    case R.id.bottom_before_bed_news:
                        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                        transaction2.replace(R.id.content, new BeforeBedNewsFragment());
                        transaction2.commit();
                        break;
                    case R.id.bottom_personal_center:
                        FragmentTransaction transaction3 = fragmentManager.beginTransaction();
                        transaction3.replace(R.id.content, new PersonalCenterFragment());
                        transaction3.commit();
                        break;
                }
            }
        });


        ReadMode = (ImageButton) findViewById(R.id.ib_toobar_read_mode);
        ReadMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this,LoginActivity.class));
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });
    }
}
