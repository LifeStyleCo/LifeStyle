package lifestyle_alfresco.lifestyle_alfresco;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import lifestyle_alfresco.lifestyle_alfresco.borrowing.CircleImageView;


public class ProfileActivity extends AppCompatActivity {
    private static final int LAYOUT2 = R.layout.activity_profile;
    private DrawerLayout drawerlayout;
    private CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT2);
        //initToolbar ();
    }


    /**private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
    }*/
}
