package club.quan9.luck_counter.SomePrivateClasses;

import android.content.SharedPreferences;

/**
 * Created by wily on 2018/3/24.
 */

public class ArrayToPref
{
    static private String regularEx="#";

    static public void putArrary(String key, String values[], SharedPreferences pref,SharedPreferences.Editor editor)
    {
        String str="";
        if(values!=null && values.length>0)
        {
            for(String value:values)
            {
                str=str+value;
                str=str+regularEx;
            }
            editor.putString(key,str);
            editor.apply();
        }
    }

    static public String[] getArrary(String key,SharedPreferences pref)
    {
        String[] str=null;
        String values;
        values=pref.getString(key,"0");
        str=values.split(regularEx);
        return str;
    }
}