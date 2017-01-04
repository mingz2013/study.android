package com.example.gridview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private GridView gridView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 得到网络视图控件对象
		gridView = (GridView)findViewById(R.id.gridView);
		// 设置GridView列数
		gridView.setNumColumns(4);
		
		/*/显示字符串
		gridView.setNumColumns(3);
		// 在GridView中显示字符串
		String[] strs = {"a","a1","a2","b","b1","b2","c","c1","c2"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, strs);
		gridView.setAdapter(adapter);
		*/
		
		// 为GridView设置适配器
		gridView.setAdapter(new MyAdapter(this));
		
	}
	// 自定义适配器
	class MyAdapter extends BaseAdapter{
		// 图片ID数组
		private Integer[] imgs = {
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
				R.drawable.photo,
		};
		// 上下文对象
		Context context;
		// 构造方法
		public MyAdapter(Context context) {
			super();
			this.context = context;
		}

		@Override
		// 获得数量
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.length;
		}

		@Override
		// 获得当前选项
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		// 获得当前选项ID
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		//创建View方法
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView;
			if(convertView == null){
				// 实例化ImageView对象
				imageView = new ImageView(context);
				// 设置ImageView对象布局
				imageView.setLayoutParams(new GridView.LayoutParams(45,45));
				// 设置边界对齐
				imageView.setAdjustViewBounds(false);
				// 设置刻度类型
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				// 设置间距
				imageView.setPadding(8, 8, 8, 8);
				
			}
			else{
				imageView = (ImageView)convertView;
			}
			// 为ImageView设置图片资源
			imageView.setImageResource(imgs[position]);
			return imageView;
		}
		
	}

	

}
