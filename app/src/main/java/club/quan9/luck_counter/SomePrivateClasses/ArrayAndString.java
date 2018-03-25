package club.quan9.luck_counter.SomePrivateClasses;

/**
 * Created by wily on 2018/3/24.
 */

public class ArrayAndString
{
    static public String[] intToString(int[] values)
    {
        String[] str=new String[values.length];
        for(int i=0;i<values.length;i++)
            str[i]=((Integer) values[i]).toString();
        return str;
    }

    static public int[] StringToInt(String[] values)
    {
        int[] inta=new int[values.length];
        for(int i=0;i<values.length;i++)
            inta[i]=Integer.valueOf(values[i]);
        return inta;
    }

    static public String[] doubleToString(double[] values)
    {
        String[] str=new String[values.length];
        for(int i=0;i<values.length;i++)
            str[i]=((Double) values[i]).toString();
        return str;
    }

    static public double[] StringToDouble(String[] values)
    {
        double[] doublea=new double[values.length];
        for(int i=0;i<values.length;i++)
            doublea[i]=Double.valueOf(values[i]);
        return doublea;
    }
}
