package cn.kcrxorg.peoplechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import cn.kcrxorg.peoplechecker.adapter.BankitemAdapter;
import cn.kcrxorg.peoplechecker.beans.Bank;
import cn.kcrxorg.peoplechecker.beans.BankItem;
import cn.kcrxorg.peoplechecker.beans.User;
import cn.kcrxorg.peoplechecker.mapper.BankMapper;
import cn.kcrxorg.peoplechecker.mapper.Usermapper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        init();
    }

    private void init() {
        startOrBussinessOver();
    }

    public void startOrBussinessOver()
    {
        BankMapper bankMapper=new BankMapper(this);
        Usermapper usermapper=new Usermapper(this);
        List<Bank> banks = bankMapper.getBanks();
        List<BankItem> bankItems=new ArrayList<BankItem>();
        for(Bank bank:banks)
        {
            BankItem bankItem=new BankItem();
            bankItem.setBankname(bank.getBankName());
            List<User> usersFromBankId = usermapper.getUsersFromBankId(bank.getBankId());
            if(usersFromBankId.size()>1) {
                bankItem.setUsername1(usersFromBankId.get(0).getUserName());
                bankItem.setUsername2(usersFromBankId.get(1).getUserName());
                bankItem.setUserpic1(usersFromBankId.get(0).getUserpic());
                bankItem.setUserpic2(usersFromBankId.get(1).getUserpic());
            }else
            {
                bankItem.setUsername1("未注册");
                bankItem.setUsername2("未注册");
            }
            bankItems.add(bankItem);
        }

        GridView contentman= (GridView) findViewById(R.id.contener_man);

        BankitemAdapter bankitemAdapter=new BankitemAdapter(bankItems,MainActivity.this);
        contentman.setAdapter(bankitemAdapter);
    }
}
