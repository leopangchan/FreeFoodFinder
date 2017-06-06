package com.example.yiupang.freefoodfinder;


import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
/**
 * Created by yiupang on 6/1/2017.
 *
 */
public class TestHttpRequest
{
    @Test
    public void TestDataString()
    {
        try
        {
            String expected = "?a=2&b=6";
            HttpRequest request = new HttpRequest();
            Map<String, String> queryParam = new HashMap<>();
            queryParam.put("a", "2");
            queryParam.put("b", "6");
            Method m1 = request.getClass().getDeclaredMethod("getDataString", Map.class);
            m1.setAccessible(true);
            Object o = m1.invoke(request, queryParam);
            assertEquals(expected, o.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
