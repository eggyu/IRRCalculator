package android.pixnet.net.irr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abreu on 2015/11/23.
 * Copyright (c) 2015, p42106@gmail.com All Rights Reserved.
 * <p/>
 * -----------------------------------------------------
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #                佛祖保佑         永無BUG             #
 * #                                                   #
 * -----------------------------------------------------
 */
public class MainActivity extends Activity implements View.OnClickListener {
    /*************************************************************************
     * 常數數宣告區
     *************************************************************************/

    /*************************************************************************
     * 變數數宣告區
     *************************************************************************/
    private double MINDIF = 0.001;

    private int LOOPNUM = 2000;

    private static int period = 0;

    @SuppressWarnings("rawtypes")
    private List netCash = new ArrayList();
    /****************************
     * View元件變數
     *********************************/
    private Button addBT, getBT, resetBT, ansBT, deleteBT;
    private EditText editMoneyET;
    private TextView ansdataTV;
    private ListView listView;
    private MyAdapter adapter;
    /**************************** Adapter元件變數 ******************************/

    /**************************** Array元件變數 ********************************/

    /**************************** 資料集合變數 *********************************/

    /**************************** 物件變數 *************************************/

    /*************************************************************************
     * Override 函式宣告 (覆寫)
     *************************************************************************/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        /* 初始化View元件,從XML檔中透過ID取得UI物件 */
        findViews();
        /* 初始化資料,包含從其他Activity傳來的Bundle資料 ,Preference資枓 */
        initData();

		/* 設置必要的系統服務元件如: Services、BroadcastReceiver */
        setSystemServices();
        /* 設置View元件對應的linstener事件,讓UI可以與用戶產生互動 */
        setLinstener();
    }

    @Override
    protected void onStart() {
        /* 查尋資料庫或是ContentProvider,取得所需資料 */
        queryDataBase();
        /* 設定各式Adapter元件,將UI與資料做整合程現 */
        setAdapter();
        super.onStart();
    }

    @Override
    protected void onResume() {
        /* 依據初始化得到的資料,若有些View元件需要重新繪制或填上預設資料,則在此處理 */
        renderUI();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        // 處理於onStop中回收的資料,在此處需要重新還原
        restoreObject();

        super.onRestart();
    }

    @Override
    protected void onStop() {
        /* 做必要的資料儲存,如存放在SharePreference或是SQL DataBase */
        saveData();
        /* 釋放DataBase相關的物件,如Cursor */
        releaseObject();
        super.onStop();
    }


    /*************************************************************************
     * 自訂API函式宣告
     *************************************************************************/

    /**
     * 取得View元件記憶體位置
     */
    private void findViews() {
        // TODO Auto-generated method stub
        addBT = (Button) findViewById(R.id.addBT);
        getBT = (Button) findViewById(R.id.getBT);
        resetBT = (Button) findViewById(R.id.resetBT);
        ansBT = (Button) findViewById(R.id.ansBT);
        deleteBT = (Button) findViewById(R.id.deleteBT);
        editMoneyET = (EditText) findViewById(R.id.editMoneyET);
        ansdataTV = (TextView) findViewById(R.id.ansdataTV);
        listView = (ListView) findViewById(R.id.listView);
    }

    /**
     * 初始化物件資料
     */
    private void initData() {
        // TODO Auto-generated method stub

    }

    /**
     * 查尋資料庫
     */
    private void queryDataBase() {
        // TODO Auto-generated method stub

    }

    /**
     * 設定Adapter元件
     */
    private void setAdapter() {
        // TODO Auto-generated method stub
        adapter = new MyAdapter();
        listView.setAdapter(adapter);

    }

    /**
     * 設置系統元件,Services、BroadcastReceiver
     */
    private void setSystemServices() {
        // TODO Auto-generated method stub

    }

    /**
     * 於View元件設置監聽Event.
     */
    private void setLinstener() {
        // TODO Auto-generated method stub
        addBT.setOnClickListener(this);
        getBT.setOnClickListener(this);
        resetBT.setOnClickListener(this);
        ansBT.setOnClickListener(this);
        deleteBT.setOnClickListener(this);
    }

    /**
     * 繪置UI
     */
    private void renderUI() {
        // TODO Auto-generated method stub

    }

    /**************************** 保存、釋放 、重啟 *************************************/

    /**
     * 保存資料
     */
    private void saveData() {
        // TODO Auto-generated method stub

    }

    /**
     * 釋放不必要的物件記憶體、Thread與Task
     */
    private void releaseObject() {
        // TODO Auto-generated method stub
    }

    /**
     * 還原Thread、Task,與相關的物件
     */
    private void restoreObject() {
        // TODO Auto-generated method stub

    }

    /*************************************************************************
     * Thread 、 AsycTask類別宣告
     *************************************************************************/

    /*************************************************************************
     * Handler類別宣告
     *************************************************************************/

    /*************************************************************************
     * Adapter類別宣告
     *************************************************************************/
    class MyAdapter extends BaseAdapter {


        public MyAdapter() {


        }

        @Override
        public int getCount() {
            if (netCash != null) {
                return netCash.size();
            } else {
                return 0;
            }
        }


        @Override
        public Object getItem(int position) {
            return netCash.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null) {
                convertView = ((LayoutInflater) MainActivity.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item, null);
                viewHolder.data = (TextView) convertView.findViewById(R.id.data);
                viewHolder.number = (TextView) convertView.findViewById(R.id.number);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.number.setText(getString(R.string.itemNumber, position + 1));

            Double data = (Double) netCash.get(position);
            if (data >= 0) {
                viewHolder.data.setText(Double.toString(data));
                viewHolder.data.setTextColor(0XFF000000);
            } else {
                viewHolder.data.setText(Double.toString(data));
                viewHolder.data.setTextColor(0XFFFF0000);
            }


            return convertView;
        }

        class ViewHolder {
            public TextView number, data;
        }


    }

    /*************************************************************************
     * 其它內部類別宣告
     *************************************************************************/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBT:
                if (null != editMoneyET.getText() && !"".equals(editMoneyET.getText().toString().trim())) {
                    netCash.add(-Math.abs(Double.valueOf(editMoneyET.getText().toString())));
                } else {
                    netCash.add(0.0);
                }
                ansdataTV.setText("");
                adapter.notifyDataSetChanged();
                break;
            case R.id.getBT:
                if (null != editMoneyET.getText() && !"".equals(editMoneyET.getText().toString().trim())) {
                    netCash.add(Math.abs(Double.valueOf(editMoneyET.getText().toString())));
                } else {
                    netCash.add(0.0);
                }
                ansdataTV.setText("");
                adapter.notifyDataSetChanged();
                break;
            case R.id.resetBT:
                netCash = null;
                netCash = new ArrayList();
                ansdataTV.setText("");
                editMoneyET.setText("");
                adapter.notifyDataSetChanged();
                break;
            case R.id.ansBT:
                Double returnData = calculator();
                if (returnData != Double.NaN) {
                    String data = String.format("%(3.2f", calculator() * 100);
                    ansdataTV.setText(data + "%");
                } else {
                    ansdataTV.setText("NaN");
                }
                break;
            case R.id.deleteBT:
                netCash.remove(netCash.size() - 1);
                ansdataTV.setText("");
                adapter.notifyDataSetChanged();
                break;
        }
    }


    private double NPV(double r) {

        double npv = 0;

        if (netCash.size() != 0) {
            for (int count = 0; count < netCash.size(); count++) {
                npv += Double.valueOf(netCash.get(count).toString()) / Math.pow(1 + r, count);
            }
            return npv;
        }
        return Double.NaN;
    }

    public double calculator() {

        double irr = 0;
        double r1 = new BigDecimal("0.1").doubleValue();
        double r2 = new BigDecimal("0.09").doubleValue();
        double npv1 = NPV(r1);
        double npv2 = NPV(r2);
//System.out.println(netCash+"--");
        int count = 0;
        while (Math.abs(npv2) > MINDIF & count < LOOPNUM) {
            irr = r2 - npv2 * (r2 - r1) / (npv2 - npv1);
            r1 = r2;
            r2 = irr;
            npv1 = npv2;
            npv2 = NPV(r2);
            count++;
// System.out.println(count+"--");
        }
// System.out.println(irr*period+"--");
        if (Math.abs(npv2) < MINDIF & count <= LOOPNUM)

//return irr * period ;
            return irr;
        else
            return Double.NaN;
    }
}
