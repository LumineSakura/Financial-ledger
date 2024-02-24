package com.sakura.tally;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sakura.tally.adapter.AccountAdapter;
import com.sakura.tally.db.AccountBean;
import com.sakura.tally.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    ListView searchLv;
    EditText searchEt;
    TextView emptyTv;
    /**
     * 数据源
     */
    List<AccountBean> mDatas;
    /**
     * 适配器对象
     */
    AccountAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        mDatas = new ArrayList<>();
        adapter = new AccountAdapter(this, mDatas);
        searchLv.setAdapter(adapter);
        //设置无数局时，显示的控件
        searchLv.setEmptyView(emptyTv);
    }

    private void initView() {
        searchEt = findViewById(R.id.search_et);
        searchLv = findViewById(R.id.search_lv);
        emptyTv = findViewById(R.id.search_tv_empty);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        if (view.getId() == R.id.search_iv_back) {
            finish();
        } else if (view.getId() == R.id.search_iv_sh) {
            String msg = searchEt.getText().toString().trim();
            //判断输入内容是否为空，如果为空，就提示不能搜索
            if (TextUtils.isEmpty(msg)) {
                Toast.makeText(this, "输入内容不能为空！", Toast.LENGTH_SHORT).show();
                return;
            }
            //开始搜索
            List<AccountBean> list = DBManager.getAccountListByRemarkFromAccounttb(msg);
            mDatas.clear();
            mDatas.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }
}