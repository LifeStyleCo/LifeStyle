package lifestyle_alfresco.lifestyle_alfresco.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lifestyle_alfresco.lifestyle_alfresco.R;

public class Example_fragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_example;

    private View view;

    public static Example_fragment getInstance() {
        Bundle args = new Bundle();
        Example_fragment fragment = new Example_fragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}
