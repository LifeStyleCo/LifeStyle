package lifestyle_alfresco.lifestyle_alfresco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import lifestyle_alfresco.lifestyle_alfresco.adapter.TabsFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar ();
        initTabs ();
        initNavigationView ();

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

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
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
                        showNotificationTab(Constants.TAB_ONE);
                        break;
                    case R.id.nav_settings:
                        Intent intent_settings = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent_settings);
                        break;
                    case R.id.nav_about:
                        Intent intent_about = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent_about);
                        break;
                }
                return true;
            }
        });
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
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        //return super.onOptionsItemSelected(item);
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
}