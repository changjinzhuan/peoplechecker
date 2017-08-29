package cn.kcrxorg.peoplechecker.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.kcrxorg.peoplechecker.R;
import cn.kcrxorg.peoplechecker.beans.BankItem;

/**
 * Created by chang on 2017/8/29.
 */

public class BankitemAdapter extends BaseAdapter {

    private List<BankItem> bankitemsList;
    private Context mContext;

    public BankitemAdapter(List<BankItem> bankitemsList, Context mContext) {
        this.bankitemsList = bankitemsList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return bankitemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return bankitemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_bank, parent, false);
        TextView bankname = (TextView) convertView.findViewById(R.id.tv_item_bankname);
        TextView username1 = (TextView) convertView.findViewById(R.id.tv_item_user1);
        TextView username2 = (TextView) convertView.findViewById(R.id.tv_item_user2);
        ImageView userpic1 = (ImageView) convertView.findViewById(R.id.iv_item_user1);
        ImageView userpic2 = (ImageView) convertView.findViewById(R.id.iv_item_user2);

        bankname.setText(bankitemsList.get(position).getBankname());
        username1.setText(bankitemsList.get(position).getUsername1());
        username2.setText(bankitemsList.get(position).getUsername2());

        byte[] user1pic = bankitemsList.get(position).getUserpic1();
        byte[] user2pic = bankitemsList.get(position).getUserpic2();

        if (user1pic.length > 0) {
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(bankitemsList.get(position).getUserpic1(), 0,
                    bankitemsList.get(position).getUserpic1().length);
            userpic1.setImageBitmap(bitmap1);
        } else {
            Bitmap bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.man);
            userpic1.setImageBitmap(bitmap1);
        }
        if (user2pic.length > 0) {
            Bitmap bitmap2 = BitmapFactory.decodeByteArray(bankitemsList.get(position).getUserpic2(), 0,
                    bankitemsList.get(position).getUserpic2().length);

            userpic2.setImageBitmap(bitmap2);
        } else {
            Bitmap bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.woman);
            userpic2.setImageBitmap(bitmap2);
        }

        return convertView;
    }
}
