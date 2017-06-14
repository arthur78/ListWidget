package com.artxak.listwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    Context mContext;
    String[] list = {"Treehouse", "Android", "Java", "Kotlin", "Anko"};

    public WidgetAdapter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView, list[position]);

        Intent intent = new Intent();
        intent.putExtra(WidgetProvider.KEY_ITEM, list[position]);
        remoteViews.setOnClickFillInIntent(R.id.list_item, intent);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
