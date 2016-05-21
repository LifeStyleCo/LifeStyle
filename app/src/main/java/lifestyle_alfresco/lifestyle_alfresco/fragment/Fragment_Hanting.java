package lifestyle_alfresco.lifestyle_alfresco.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lifestyle_alfresco.lifestyle_alfresco.R;
import lifestyle_alfresco.lifestyle_alfresco.adapter.PostListAdapter;
import lifestyle_alfresco.lifestyle_alfresco.dto.PostDTO;

public class Fragment_Hanting extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_hanting;

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
        RecyclerView rv = (RecyclerView)  view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new PostListAdapter(CreateMockPostListData()));
        return view;
    }
    //Ниже заглушка данных с сервера
    private List<PostDTO> CreateMockPostListData() {
        List<PostDTO> data = new ArrayList<>();
        data.add(new PostDTO("Item 1"));
        data.add(new PostDTO("Item 2"));
        data.add(new PostDTO("Item 3"));
        data.add(new PostDTO("Item 4"));
        data.add(new PostDTO("Item 5"));
        data.add(new PostDTO("Item 6"));
        return data;
    }
    public void setContext(Context context) {
        this.context = context;
    }

}
