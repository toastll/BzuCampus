package cn.edu.bzu.bzucampus.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.edu.bzu.bzucampus.BaseActivity;
import cn.edu.bzu.bzucampus.R;

/**
 * Created by monster on 2015/10/4.
 */
public class NewsInformActivity extends BaseActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_inform);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("新闻详情");  //设置标题
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.item_test:
                        Toast.makeText(NewsInformActivity.this,"测试Toast",Toast.LENGTH_SHORT).show();
                    break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id){
//            case R.id.item_test:
//                Toast.makeText(NewsInformActivity.this,"测试Toast",Toast.LENGTH_SHORT).show();
//            break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
