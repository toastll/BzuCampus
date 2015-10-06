package cn.edu.bzu.bzucampus.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;
import cn.edu.bzu.bzucampus.BaseActivity;
import cn.edu.bzu.bzucampus.R;
import cn.edu.bzu.bzucampus.entity.SchoolUser;

/**
 *
 * 软件登陆
 * Created by monster on 2015/10/6.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Toolbar mToolbar;
    private Button btn_login,btn_regist;
    private EditText edt_user,edt_pass;
    private String user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        btn_regist.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    private void initView() {
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_regist= (Button) findViewById(R.id.btn_regist);
        edt_user= (EditText) findViewById(R.id.edt_user);
        edt_pass= (EditText) findViewById(R.id.edt_pass);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("软件登陆");  //设置标题
        mToolbar.setNavigationIcon(R.mipmap.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.item_test:
                        Toast.makeText(LoginActivity.this, "测试Toast", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();


                break;
            case R.id.btn_regist:
                break;
        }
    }

    /**
     * 程序登陆
     */
    private void login() {
        user = edt_user.getText().toString();
        pass = edt_pass.getText().toString();
        if(TextUtils.isEmpty(user)&&TextUtils.isEmpty(pass)){
            toast("用户名或密码未填写");
        }else{
            SchoolUser schoolUser = new SchoolUser();
            schoolUser.setUsername(user);
            schoolUser.setPassword(pass);
            schoolUser.login(LoginActivity.this, new SaveListener() {
                @Override
                public void onSuccess() {
                    toast("登陆成功");
                }

                @Override
                public void onFailure(int i, String s) {
                    toast("登陆失败"+s);
                }
            });
        }
    }
}
