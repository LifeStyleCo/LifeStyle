package lifestyle_alfresco.lifestyle_alfresco.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lifestyle_alfresco.lifestyle_alfresco.R;

public class Fragment_Profile extends AbstractTabFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_profile, container, false);
    }
}
