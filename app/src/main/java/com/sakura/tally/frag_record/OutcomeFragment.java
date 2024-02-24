package com.sakura.tally.frag_record;

import com.sakura.tally.R;
import com.sakura.tally.db.DBManager;
import com.sakura.tally.db.TypeBean;

import java.util.List;

/**
 * @author : Akubi
 * @date : 2024/1/26 18:01
 */
public class OutcomeFragment extends BaseRecordFragment {

    /**
     * 重写
     */
    @Override
    public void loadDataGV() {
        super.loadDataGV();
        super.loadDataGV();
        //获取数据库当中的数据源
        List<TypeBean> outlist = DBManager.getTypeList(0);
        typeList.addAll(outlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.ic_qita_fs);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(0);
        DBManager.insertItemToAccounttb(accountBean);
    }
}
