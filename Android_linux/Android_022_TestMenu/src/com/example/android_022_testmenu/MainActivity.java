package com.example.android_022_testmenu;

import android.location.Address;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	Menu myMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        
        // add o few normal menus
        addRegularMenuItems(menu);
        
        add5SecondaryMenuItems(menu);
        
        
    	return true;
    }
    
    // 添加常规菜单项
    private void addRegularMenuItems(Menu menu)
    {
    	int base = Menu.FIRST;	// value is 1
    	
    	menu.add(base, base, base, "append");
    	menu.add(base, base + 1, base + 1, "item 2");
    	menu.add(base, base + 2, base + 2, "clear");
    	
    	menu.add(base, base + 3, base + 3, "hide secondary");
    	menu.add(base, base + 4, base + 4, "show secondary");
    	
    	menu.add(base, base + 5, base + 5, "enable secondary");
    	menu.add(base, base + 6, base + 6, "disable secondary");
    	
    	menu.add(base, base + 7, base + 7, "check secondary");
    	menu.add(base, base + 8, base + 8, "unckeck secondary");
    	
    }
    
    // 添加辅助菜单项
    private void add5SecondaryMenuItems(Menu menu)
    {
    	int base = Menu.CATEGORY_SECONDARY;
    	
    	menu.add(base, base + 1, base + 1, "sec. item 1");
    	menu.add(base, base + 2, base + 2, "sec. item 2");
    	menu.add(base, base + 3, base + 3, "sec. item 3");
    	menu.add(base, base + 4, base + 4, "sec. item 4");
    	menu.add(base, base + 5, base + 5, "sec. item 5");
    	
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 1:
			appendText("\nhello");
			break;
		case 2:
			appendText("\nitem2");
			break;
		case 3:
			emptyText();
			break;
		case 4:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, false);
			break;
		case 5:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, true);
			break;
		case 6:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, true);
			break;
		case 7:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, false);
			break;
		case 8:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, false);
			break;
		case 9:
			this.appendMenuItemText(item);
			this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY, false);
			break;

		default:
			this.appendMenuItemText(item);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
    
	
	private void appendText(String Text){
		textView.setText(textView.getText() + Text);
	}
	private void emptyText(){
		textView.setText("");
	}
	private void appendMenuItemText(MenuItem menuItem){
		String title = menuItem.getTitle().toString();
		textView.setText(textView.getText() + "\n" + title);
	}
	
	
}
