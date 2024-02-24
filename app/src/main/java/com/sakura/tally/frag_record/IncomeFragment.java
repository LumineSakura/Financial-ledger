package com.sakura.tally.frag_record;

import com.sakura.tally.R;
import com.sakura.tally.db.DBManager;
import com.sakura.tally.db.TypeBean;

import java.util.List;


public class IncomeFragment extends BaseRecordFragment {

    @Override
    public void loadDataGV() {
        super.loadDataGV();
        //获取数据库当中的数据源
        List<TypeBean> inlist = DBManager.getTypeList(1);
        typeList.addAll(inlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.in_qt_fs);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(1);
        DBManager.insertItemToAccounttb(accountBean);
    }
}