package lifestyle_alfresco.lifestyle_alfresco.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import lifestyle_alfresco.lifestyle_alfresco.fragment.AbstractTabFragment;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Camping;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Fishing;
import lifestyle_alfresco.lifestyle_alfresco.fragment.Fragment_Hanting;

/**class HistoryFragment{

}*/

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    /** private List<RemindDTO> data;
    private HistoryFragment historyFragment;*/

    /** Вот этот Адаптер хз вообще к чему, но через него всё работает  */
    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        /**historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);*/
        tabs.put(0, Fragment_Fishing.getInstance(context));
        tabs.put(1, Fragment_Hanting.getInstance(context));
        tabs.put(2, Fragment_Camping.getInstance(context));
    }
}
