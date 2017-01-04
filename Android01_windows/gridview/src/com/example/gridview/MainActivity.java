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
		// �õ�������ͼ�ؼ�����
		gridView = (GridView)findViewById(R.id.gridView);
		// ����GridView����
		gridView.setNumColumns(4);
		
		/*/��ʾ�ַ���
		gridView.setNumColumns(3);
		// ��GridView����ʾ�ַ���
		String[] strs = {"a","a1","a2","b","b1","b2","c","c1","c2"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, strs);
		gridView.setAdapter(adapter);
		*/
		
		// ΪGridView����������
		gridView.setAdapter(new MyAdapter(this));
		
	}
	// �Զ���������
	class MyAdapter extends BaseAdapter{
		// ͼƬID����
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
		// �����Ķ���
		Context context;
		// ���췽��
		public MyAdapter(Context context) {
			super();
			this.context = context;
		}

		@Override
		// �������
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.length;
		}

		@Override
		// ��õ�ǰѡ��
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		// ��õ�ǰѡ��ID
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		//����View����
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView;
			if(convertView == null){
				// ʵ����ImageView����
				imageView = new ImageView(context);
				// ����ImageView���󲼾�
				imageView.setLayoutParams(new GridView.LayoutParams(45,45));
				// ���ñ߽����
				imageView.setAdjustViewBounds(false);
				// ���ÿ̶�����
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				// ���ü��
				imageView.setPadding(8, 8, 8, 8);
				
			}
			else{
				imageView = (ImageView)convertView;
			}
			// ΪImageView����ͼƬ��Դ
			imageView.setImageResource(imgs[position]);
			return imageView;
		}
		
	}

	

}
