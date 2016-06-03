package lifestyle_alfresco.lifestyle_alfresco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import lifestyle_alfresco.lifestyle_alfresco.adapter.TabsFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;  //Менять основной лейаут
    private Toolbar toolbar;
    private ViewPager viewpager;
    private ButtonBarLayout buttonBarLayout;  //хз, что она не используется

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar ();
        initTabs ();
        initNavigationView ();
        //initButtonBarLayout();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent_about);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
            }
        });
    }

    //@SuppressLint("WrongViewCast")              //Всё работает и без этого...
    //private void initButtonBarLayout(){
    //    buttonBarLayout = (ButtonBarLayout) findViewById(R.id.buttunbarlayout);
    //    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
     //       @Override  //Хуйня ниже нихуя не работает
    //        public boolean onMenuItemClick(MenuItem menuItem) {
    //            return true;
    //        }
    //    });
    //}

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);

    }

    private void initNavigationView() {
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                assert drawerLayout != null;
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_hunting:
                        showNotificationTab2(Constants.TAB_TWO);
                        break;
                    case R.id.nav_cemping:
                        showNotificationTab3(Constants.TAB_THREE);
                        break;
                    case R.id.nav_fishing:
                        showNotificationTab(Constants.TAB_ONE);
                        break;
                    case R.id.nav_profile:
                        Intent intent_profile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent_profile);
                        break;
                    case R.id.nav_settings:
                        Intent intent_settings = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent_settings);
                        break;
                    //case R.id.nav_about:
                    //    Intent intent_about = new Intent(MainActivity.this, AboutActivity.class);
                    //    startActivity(intent_about);
                    //    break;
                }
                return true;
            }
        });
    }

    private void initTabs() {
        viewpager = (ViewPager)findViewById(R.id.ViewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        TabLayout tablayout = (TabLayout)findViewById(R.id.tablayout);
        assert tablayout != null;
        tablayout.setupWithViewPager(viewpager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent_settings2 = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent_settings2);
                break;
            case R.id.search:
                //Хз что сюда пока
                break;
            case R.id.action_filter:
                //И сюда...
                break;
        }
        return true;
    }


    private void showNotificationTab(int tabOne) {
        viewpager.setCurrentItem(Constants.TAB_ONE);
    }

    private void showNotificationTab2(int tabTwo) {
        viewpager.setCurrentItem(Constants.TAB_TWO);
    }

    private void showNotificationTab3(int tabThree) {
        viewpager.setCurrentItem(Constants.TAB_THREE);
    }
}

/** public boolean onNavigationItemSelected(MenuItem item) {
 int id = item.getItemId();
 if (id == R.id.nav_fishing) {
 } else if (id == R.id.nav_hunting) {
 } else if (id == R.id.nav_cemping) {
 } else if (id == R.id.nav_settings) {
 }
 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
 drawer.closeDrawer(GravityCompat.START);
 return true;
 }*/