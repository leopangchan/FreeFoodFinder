package com.example.yiupang.freefoodfinder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import java.lang.reflect.Method;

/**
 * Created by yiupang on 6/4/2017.
 *
 */
public class TestMainActivity
{
    @Test
    public void TestSwitchToAboutUs()
    {
        try
        {
            AboutUsScreen expected = new AboutUsScreen();
            MainActivity m = new MainActivity();
            Method m1 = m.getClass().getDeclaredMethod("getSelectedFragement", int.class);
            m1.setAccessible(true);
            Object o = m1.invoke(m, 1);
            assertThat(expected, instanceOf(o.getClass()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
