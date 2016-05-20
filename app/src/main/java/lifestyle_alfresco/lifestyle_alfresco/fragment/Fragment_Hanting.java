package lifestyle_alfresco.lifestyle_alfresco.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lifestyle_alfresco.lifestyle_alfresco.R;

public class Fragment_Hanting extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_example;

    public static Fragment_Hanting getInstance(Context context) {
        Bundle args = new Bundle();
        Fragment_Hanting fragment = new Fragment_Hanting();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.hunting));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
