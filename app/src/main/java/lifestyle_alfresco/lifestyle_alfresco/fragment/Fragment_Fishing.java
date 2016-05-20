package lifestyle_alfresco.lifestyle_alfresco.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lifestyle_alfresco.lifestyle_alfresco.R;

public class Fragment_Fishing extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_example;

    public static Fragment_Fishing getInstance(Context context) {
        Bundle args = new Bundle();
        Fragment_Fishing fragment = new Fragment_Fishing();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.fishing));

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
