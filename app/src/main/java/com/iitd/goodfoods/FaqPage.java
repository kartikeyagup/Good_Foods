package com.iitd.goodfoods;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FaqPage extends Activity {

    private final int CELL_DEFAULT_HEIGHT = 200;
    private final int NUM_OF_CELLS = 12;

    private ExpandingListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_page);

        ExpandableListItem[] values = new ExpandableListItem[] {
                new ExpandableListItem("Question Goes here", R.drawable.batman, CELL_DEFAULT_HEIGHT,
                        "answer goes here"),
                new ExpandableListItem("Question Goes here", R.drawable.batman, CELL_DEFAULT_HEIGHT,
                        "answer goes here"),
                new ExpandableListItem("Question Goes here", R.drawable.batman, CELL_DEFAULT_HEIGHT,
                        "answer goes here"),
        };

        List<ExpandableListItem> mData = new ArrayList<>();

        for (int i = 0; i < NUM_OF_CELLS; i++) {
            ExpandableListItem obj = values[i % values.length];
            mData.add(new ExpandableListItem(obj.getTitle(), obj.getImgResource(),
                    obj.getCollapsedHeight(), obj.getText()));
        }

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.list_view_item, mData);

        mListView = (ExpandingListView)findViewById(R.id.main_list_view);
        mListView.setAdapter(adapter);
        mListView.setDivider(null);
    }
}
