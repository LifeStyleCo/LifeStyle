package lifestyle_alfresco.lifestyle_alfresco.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import lifestyle_alfresco.lifestyle_alfresco.Constants;
import lifestyle_alfresco.lifestyle_alfresco.MainActivity;
import lifestyle_alfresco.lifestyle_alfresco.R;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Camping;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Main;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Profile;


public class Utils {


    public static final int ACCOUNTS_LOGOUT_ID = 110;
    private ViewPager viewpager;


    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            //
        }

    }


    public static Drawer.OnDrawerItemClickListener handlerOnClick(final Drawer.Result drawerResult, final MainActivity activity) {
        return new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                //check if the drawerItem is set.
                //there are different reasons for the drawerItem to be null
                //--> click on the header
                //--> click on the footer
                //those items don't contain a drawerItem

                if (drawerItem != null) {

                    if (drawerItem.getIdentifier() == 1) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Profile()).commit();
                    } else if (drawerItem.getIdentifier() == 2) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Main()).commit();
                        showNotificationTab(Constants.TAB_ONE);
                    } else if (drawerItem.getIdentifier() == 3) {
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Camping()).commit();
                    } else if (drawerItem.getIdentifier() == 70) {
                        // Rate App
                        try {
                            Intent int_rate = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + activity.getApplicationContext().getPackageName()));
                            int_rate.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.getApplicationContext().startActivity(int_rate);
                        } catch (Exception e) {
                            //
                        }
                    }

                }
            }
        };
    }


    public static AccountHeader.Result getAccountHeader(final MainActivity activity, final Bundle savedInstanceState) {

        // Create a few sample profile
        // NOTE you have to define the loader logic too. See the CustomApplication for more details
        final IProfile profile = new ProfileDrawerItem().withName("User Name").withEmail("useremail@gmail.com");
        /*final IProfile profile2 = new ProfileDrawerItem().withName("Bernat Borras").withEmail("alorma@github.com").withIcon(Uri.parse("https://avatars3.githubusercontent.com/u/887462?v=3&s=460"));
        final IProfile profile3 = new ProfileDrawerItem().withName("Max Muster").withEmail("max.mustermann@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile2));
        final IProfile profile4 = new ProfileDrawerItem().withName("Felix House").withEmail("felix.house@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile3));
        final IProfile profile5 = new ProfileDrawerItem().withName("Mr. X").withEmail("mister.x.super@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile4)).withIdentifier(4);
        final IProfile profile6 = new ProfileDrawerItem().withName("Batman").withEmail("batman@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile5));
*/
        // Create the AccountHeader
        return new AccountHeader()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.side_nav_bar)
                .withProfileImagesClickable(true)
                .withProfileImagesVisible(true)
                .addProfiles(
                        profile,
                      /*  profile2,
                        profile3,
                        profile4,
                        profile5,
                        profile6,*/
                        //don't ask but google uses 14dp for the add account icon in gmail but 20dp for the normal icons (like manage account)
                        //new ProfileSettingDrawerItem().withName("Add Account").withDescription("Add new GitHub Account").withIcon(new IconicsDrawable(activity, GoogleMaterial.Icon.gmd_add).actionBarSize().paddingDp(5).colorRes(R.color.material_drawer_primary_text)).withIdentifier(111),
                        new ProfileSettingDrawerItem().withName("Выход").withIcon(new IconicsDrawable(activity, GoogleMaterial.Icon.gmd_exit_to_app).actionBarSize().paddingDp(5).colorRes(R.color.material_drawer_primary_text)).withIdentifier(ACCOUNTS_LOGOUT_ID)
                        //new ProfileSettingDrawerItem().withName("Manage Account").withIcon(GoogleMaterial.Icon.gmd_settings)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        if (profile instanceof IDrawerItem && ((IDrawerItem) profile).getIdentifier() == ACCOUNTS_LOGOUT_ID) {
                            //headerResult.addProfiles();
                        }

                        //false if you have not consumed the event and it should close the drawer
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    public static Drawer.Result createCommonDrawer(final MainActivity activity, Toolbar toolbar, AccountHeader.Result headerResult) {

        Drawer.Result drawerResult = new Drawer()
                .withActivity(activity)
                .withHeader(R.layout.navigation_header)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.profile).withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.fishing).withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.hunting).withIcon(GoogleMaterial.Icon.gmd_done_all).withIdentifier(3),
                        // Вывод НЕ для Google Play
                        //new PrimaryDrawerItem().withName(R.string.info_fr3).withIcon(GoogleMaterial.Icon.gmd_attach_money).withIdentifier(3)
                        // Вывод для Google Play
                        new PrimaryDrawerItem().withName(R.string.camping).withIcon(GoogleMaterial.Icon.gmd_attach_money).withIdentifier(4),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.action_settings).withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(50)
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(GoogleMaterial.Icon.gmd_help).withIdentifier(60),
                        //new DividerDrawerItem(),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_rate).withIdentifier(70),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_donate).withIdentifier(80)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public boolean equals(Object o) {
                        return super.equals(o);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        //Toast.makeText(MainActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                        hideSoftKeyboard(activity);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        //Toast.makeText(MainActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();


        drawerResult.setOnDrawerItemClickListener(handlerOnClick(drawerResult, activity));

        return drawerResult;
    }


    private static void showNotificationTab(int tabOne) {
        viewpager.setCurrentItem(Constants.TAB_ONE);
    }

    private void showNotificationTab2(int tabTwo) {
        viewpager.setCurrentItem(Constants.TAB_TWO);
    }

    private void showNotificationTab3(int tabThree) {
        viewpager.setCurrentItem(Constants.TAB_THREE);
    }

}
