package cn.edu.bzu.bzucampus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import cn.edu.bzu.bzucampus.adapter.ViewPagerAdapter;
import cn.edu.bzu.bzucampus.fragment.LifeFragment;
import cn.edu.bzu.bzucampus.fragment.TopNewsFragment;
import cn.edu.bzu.bzucampus.fragment.MarketNewsFragment;
import cn.edu.bzu.bzucampus.fragment.GraduateNewsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    //菜单的所在布局
    private NavigationView mNavigationView;

    //ActionBarDrawerToggle 点击菜单出现与关闭
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    //TabLayout和ViewPager组合实现切换的功能
    private TabLayout mTabLayout;  //TabLayout
    private ViewPager mViewPager;  //ViewPager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
        initMainContent();
        initAction();
    }

    /**
     * 初始化控件的动作监听
     */
    private void initAction() {

        //设置侧滑菜单点击监听
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    //返回首页
                    case R.id.nav_home:
                        mViewPager.setCurrentItem(0);
                        break;
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /**
     * 初始化TabLayout和ViewPager
     */
    private void initMainContent() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment topNews = new TopNewsFragment();
        Fragment graduateNews = new GraduateNewsFragment();
        Fragment marketNews = new MarketNewsFragment();
        Fragment lifeNews = new LifeFragment();

        adapter.addFragment(topNews, "新闻头条");
        adapter.addFragment(graduateNews, "升学快讯");
        adapter.addFragment(marketNews, "二手市场");
        adapter.addFragment(lifeNews, "生活百态");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        mToolbar.setTitle("微校园");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }


    /**
     * 初始化控件
     */
    private void initView() {
        //ToolBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        //FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Star", Toast.LENGTH_SHORT).show();
            }
        });

        //DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawer);

        //NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.nv_main_menu);

        //ViewPager and TabLayout
        mViewPager = (ViewPager) findViewById(R.id.vp_main_content);

        mTabLayout = (TabLayout) findViewById(R.id.tl_main_tabs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
