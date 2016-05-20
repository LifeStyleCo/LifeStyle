package lifestyle_alfresco.lifestyle_alfresco.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lifestyle_alfresco.lifestyle_alfresco.fragment.Example_fragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

private String [] tabs;
    /** Вот этот Адаптер хз вообще к чему, но через него всё работает  */
    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[] {
                "Рыбалка",
                "Охота",
                "Кемпинг"
        };

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Example_fragment.getInstance();
            case 1:
                return Example_fragment.getInstance();
            case 2:
                return Example_fragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
