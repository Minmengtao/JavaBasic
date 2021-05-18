package deepcopy;

import java.util.Arrays;

public class deep {
    public static void main(String[] args) {
        String[] s1 = new String[]{"Hi", "Bi", "Xi"};
        String[] s2 = new String[s1.length];
        System.arraycopy(s1, 0, s2, 0, s1.length);
        s1[2] = "Hier";
        System.out.println(Arrays.toString(s1));

        System.out.println(Arrays.toString(s2));
        String a = "123";
        String b = new String("123");

        String str = "Hier";
        String str1 = "Hier";
        String str2 = new String("Hier");
        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str.equals(str2));
    }
}
