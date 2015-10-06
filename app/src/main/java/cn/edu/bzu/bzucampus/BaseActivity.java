package cn.edu.bzu.bzucampus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

/**
 * Created by monster on 2015/10/6.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String APPLICATIONID = "169334dda8b42be4e83cab3a15f0acb7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,APPLICATIONID);
    }

    /**
     * 弹出Toast语句
     * @param s
     */
    public void toast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
