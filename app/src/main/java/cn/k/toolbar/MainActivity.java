package cn.k.toolbar;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    private LinearLayout layout;

    private TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 设置logo 图片
        toolbar.setLogo(R.mipmap.ic_launcher);
        // 设置标题
        toolbar.setTitle("Hello World");
        // 设置副标题
        toolbar.setSubtitle("Hello");
        // 使用 Toolbar 替换 ActionBar
        setSupportActionBar(toolbar);
        // 设置导航图标,后退等图标
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        // 导航点击事件
        toolbar.setNavigationOnClickListener(onClickListener);
        // 菜单点击事件
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

        btn = (Button) findViewById(R.id.btnVisibly);
        layout = (LinearLayout) findViewById(R.id.layoutLinear);
        textContent = (TextView) findViewById(R.id.textContent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textContent.isShown()){
                    textContent.setVisibility(View.GONE);
                }else {
                    textContent.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "NavigationIcon", Toast.LENGTH_SHORT).show();
        }
    };

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()){
                case R.id.action_search:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click settings";
                    break;
            }
            if (!msg.equals("")){
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "Expand", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "Collapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
