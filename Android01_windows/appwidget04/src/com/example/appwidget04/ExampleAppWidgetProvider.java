package com.example.appwidget04;



import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider{
	// ����һ�������ַ���,�ó�����������action
	private static final String UPDATE_ACTION = "example.appwidget04.UPDATE_APP_WIDGET";
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
		String action = intent.getAction();
		if(UPDATE_ACTION.equals(action)){// �Լ������action
			System.out.println("onReceive---->" + UPDATE_ACTION);
			// �õ�remoteviews�����������пؼ�
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
			// �޸�ImageView�ؼ�����Դ�ļ�
			remoteViews.setImageViewResource(R.id.imageId, R.drawable.girl);
			// �޸�TextView���ı�
			remoteViews.setTextViewText(R.id.widgetTextId, "test");
			// �õ�appWidgetManager����
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			// Componentname ����appwidget����
			ComponentName componentName = new ComponentName(context, ExampleAppWidgetProvider.class);
			// ����һ��
			appWidgetManager.updateAppWidget(componentName, remoteViews);
		}
		else{// ϵͳ�Լ���action
			super.onReceive(context, intent);
		}
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		// ����һ��Intent����
				Intent intent = new Intent();
				// ΪIntent��������action
				intent.setAction(UPDATE_ACTION);
				// ʹ��getBroadcast�����õ�һ��PendingIntent����,���ö���ִ��ʱ,�ᷢ��һ���㲥
				PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
				// �õ�RemoteViews,�����¼�
				RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
				remoteViews.setOnClickPendingIntent(R.id.widgetbuttonId, pendingIntent);
				// ����һ��
				appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
	}

}
