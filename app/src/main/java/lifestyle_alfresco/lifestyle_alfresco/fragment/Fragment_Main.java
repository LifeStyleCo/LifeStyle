package lifestyle_alfresco.lifestyle_alfresco.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import lifestyle_alfresco.lifestyle_alfresco.AboutActivity;
import lifestyle_alfresco.lifestyle_alfresco.Constants;
import lifestyle_alfresco.lifestyle_alfresco.MainActivity;
import lifestyle_alfresco.lifestyle_alfresco.R;
import lifestyle_alfresco.lifestyle_alfresco.adapter.TabsFragmentAdapter;


public class Fragment_Main extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.activity_main_fragment;  //Менять основной лейаут
    private Toolbar toolbar;
    private ViewPager viewpager;
    private ButtonBarLayout buttonBarLayout;  //хз, что она не используется
    private DrawerLayout drawerLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(LAYOUT, container, false);
        viewpager = (ViewPager)rootView.findViewById(R.id.ViewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        TabLayout tablayout = (TabLayout)rootView.findViewById(R.id.tablayout);
        assert tablayout != null;
        tablayout.setupWithViewPager(viewpager);
        return rootView;
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