package com.example.appwidget02;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider{

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		for(int i = 0; i < appWidgetIds.length; i++) {
			System.out.println(appWidgetIds[i]);
			// ����һ��Intent����
			Intent intent = new Intent(context, TargetActivity.class);
			// ����һ��PendingIntent
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
			// �õ�һ��RemoteViews�������������еĿؼ�
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
			// ����һ���¼���Ϊ��ť���¼���������
			// ��һ����������ָ�����󶨴�������ID
			// �ڶ�����������ָ���¼�����ʱ���ĸ�PendingIntent����ִ��
			remoteViews.setOnClickPendingIntent(R.id.widgetButtonId, pendingIntent);
			// ����AppWidget
			// ��һ����������ָ��������AppWidget��ID���ڶ�������Ҫ���µĶ���
			appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
		}
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

}
