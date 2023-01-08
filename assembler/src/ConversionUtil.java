import java.util.HashMap;
import java.util.Map;

public class ConversionUtil {

    private static final Map<String, String> hexMap = new HashMap<>() {{
        put("0000", "0");
        put("0001", "1");
        put("0010", "2");
        put("0011", "3");
        put("0100", "4");
        put("0101", "5");
        put("0110", "6");
        put("0111", "7");
        put("1000", "8");
        put("1001", "9");
        put("1010", "A");
        put("1011", "B");
        put("1100", "C");
        put("1101", "D");
        put("1110", "E");
        put("1111", "F");
    }};

    public static String binaryToHexadecimal(final String binary) throws Exception {
        final StringBuilder builder = new StringBuilder();

        int length = binary.length();
        for (int i = 0; i < length; i += 4) {
            final String binGroup = binary.substring(i, Math.min(length, i + 4));
            builder.append(hexMap.get(binGroup));
        }

        return builder.toString();
    }
}
