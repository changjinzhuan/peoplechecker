package cn.kcrxorg.peoplechecker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import cn.kcrxorg.peoplechecker.beans.Bank;
import cn.kcrxorg.peoplechecker.beans.User;
import cn.kcrxorg.peoplechecker.mapper.BankMapper;
import cn.kcrxorg.peoplechecker.mapper.DBHelper;
import cn.kcrxorg.peoplechecker.mapper.Usermapper;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.kcrxorg.peoplechecker", appContext.getPackageName());
    }
@Test
    public void bankMappertest()
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        BankMapper bankMapper=new BankMapper(appContext);
        Bank newbank=new Bank();
        newbank.setBankName("包商银行");
        newbank.setBankSn("00000009");
        bankMapper.insertBank(newbank);

        List<Bank> banks = bankMapper.getBanks();
        for(Bank bank:banks)
        {
            Log.d("peoplechecker",bank.getBankName());
        }

        assertEquals(6, banks.size());
    }
    @Test
    public void userMappertest()
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Usermapper usermapper=new Usermapper(appContext);
        List<User> userList = usermapper.getUsers();
        for (User user:userList)
        {
            Log.d("peoplechecker",user.getUserName());
        }
    }
}
