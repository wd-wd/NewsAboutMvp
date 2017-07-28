package com.yimeng.dayou.mynewssample.main.widget;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.about.widget.AboutMeFragment;
import com.yimeng.dayou.mynewssample.images.widget.ImagesFragment;
import com.yimeng.dayou.mynewssample.main.presenter.MainPresenter;
import com.yimeng.dayou.mynewssample.main.presenter.impl.MainPresenterImpl;
import com.yimeng.dayou.mynewssample.main.view.MainView;
import com.yimeng.dayou.mynewssample.news.widget.NewsFragment;
import com.yimeng.dayou.mynewssample.weather.widget.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新闻");
//        toolbar.setTitleTextColor(Color.BLUE);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        //给Drawlayout设置监听，1）自己实现监听   2)drawerToggle 自带了监听，会监听侧滑事件，同时对导航菜单设置了 旋转的效果
        //mDrawerLayout.setDrawerListener(drawerToggle);
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            //在侧滑菜单滑动的时候调用
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //通过自己使用属性动画来 实现当侧滑菜单滑出的时候， 内容部分有一个向右平移的动画
//                Log.i("tz", "slideOffset" + slideOffset);//侧滑的偏移量的百分比
                View content = drawer.getChildAt(0);
                View menu = drawerView;

                //侧滑的内容部分进行往右平移
                ViewHelper.setTranslationX(content, slideOffset * menu.getMeasuredWidth());

//                ViewHelper.setScaleX(content,(1-slideOffset*0.7f));
//                ViewHelper.setScaleY(content,(1-slideOffset*0.7f));//0~1


            }

            //侧滑菜单打开的时候 调用
            @Override
            public void onDrawerOpened(View drawerView) {

            }

            //侧滑菜单关闭的时候 调用
            @Override
            public void onDrawerClosed(View drawerView) {

            }

            //侧滑带单状态发生变化的时候调用
            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        mainPresenter = new MainPresenterImpl(this);//初始化
        setupDrawerContent(navigationView);//调用设置drawlayout内容的方法
        switch2News();//默认选中新闻界面
    }
    private Long firstTime = 0L;
    /**
     * back键
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1500) {
            Toast.makeText(MyApplication.getContext(), getString(R.string.back_again_exit),Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * 设置drawlayout的内容
     *
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mainPresenter.switchNavigation(item.getItemId());
                item.setChecked(true);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;

            }
        });
    }

  /*  @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navigation_item_news) {
            // Handle the camera action
        } else if (id == R.id.navigation_item_images) {

        } else if (id == R.id.navigation_item_weather) {

        } else if (id == R.id.navigation_item_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    /**
     * 选择新闻界面
     */
    @Override
    public void switch2News() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new  NewsFragment())
                .commit();
        toolbar.setTitle(R.string.navigation_news);
    }

    /**
     * 选择图片界面
     */
    @Override
    public void switch2Images() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new ImagesFragment())
                .commit();
        toolbar.setTitle(R.string.navigation_images);
    }

    /**
     * 选择天气界面
     */
    @Override
    public void switch2Weather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new WeatherFragment())
                .commit();
        toolbar.setTitle(R.string.navigation_weather);
    }

    /**
     * 选择关于我的界面
     */
    @Override
    public void switch2AboutMe() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new AboutMeFragment())
                .commit();
        toolbar.setTitle(R.string.navigation_about);
    }
}
