package pl.marczak;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 11 lip 2016.
 * 20 : 08
 */
public class Utils {
    public static void log(String s){
        System.out.println(s);
    }

    public static <T> List<T > setToList(Set<T> t) {
        List<T> list = new ArrayList<>();
        list.addAll(t);
        return list;
    }

    public static<T> String toString(List<T> a) {
        if (a == null)
            return "null";
        int iMax = a.size() - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a.get(i));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
