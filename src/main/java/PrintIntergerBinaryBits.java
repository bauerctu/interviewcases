public class PrintIntergerBinaryBits {

    private static String convert(int n) {
        int pivot = 0x40000000;
        StringBuilder sb = new StringBuilder();


        if (n < 0) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        int b = 0;
        int i = 30;
        while (i >= 0) {
            b = n & pivot;
            pivot >>>= 1;
            i--;
            if (b > 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int i1 = -8;
        int i2 = -1024;
        int i3 = -65535;
        int i4 = 1024;
        int i5 = 65535;
        int i6 = -1;
        int i7 = 2147483647;
        print(i1, "i1");
        print(i2, "i2");
        print(i3, "i3");
        print(i4, "i4");
        print(i5, "i5");
        print(i6, "i6");
        print(i7, "i7");
    }

    private static void print(int i, String variableName) {
        System.out.println(variableName + " " + convert(i) + " " + Integer.toBinaryString(i).equals(convert(i)));
        System.out.println(variableName + " " + Integer.toBinaryString(i));
    }
}
