public class RadixTransform {

    // Decimal to -> ...
    public static String DecBin(String dec){
        int intdec = Integer.parseInt(dec);
        String bin = Integer.toBinaryString(intdec);
        return bin;
    }

    public static String DecOct(String dec) {
        int intdec = Integer.parseInt(dec);
        String oct = Integer.toOctalString(intdec);
        return oct;
    }

    public static String DecHex(String dec) {
        int intdec = Integer.parseInt(dec);
        String hex = Integer.toHexString(intdec);
        return hex;
    }

    public static char DecAscii(String dec) {
        int ascii = Integer.parseInt(dec);
        char text = (char) ascii;
        return text;
    }



    // Binary to -> ...
    public static int BinDec(String bin) {
        int dec = Integer.parseInt(bin, 2);
        return dec;
    }

    public static String BinOct(String bin) {
        int dec = Integer.parseInt(bin, 2);
        String oct = Integer.toOctalString(dec);
        return oct;
    }

    public static String BinHex(String bin) {
        int dec = Integer.parseInt(bin, 2);
        String hex = Integer.toHexString(dec);
        return hex;
    }

    public static char BinAscii(String bin) {
        int dec = Integer.parseInt(bin, 2);
        char text = (char) dec;
        return text;
    }



    // Octal to -> ...
    public static int OctDec(String oct) {
        int dec = Integer.parseInt(oct, 8);
        return dec;
    }

    public static String OctBin(String oct) {
        String bin = Integer.toBinaryString(Integer.parseInt(oct, 8));
        return bin;
    }

    public static String OctHex(String oct) {
        int dec = Integer.parseInt(oct, 8);
        String hex = Integer.toHexString(dec);
        return hex;
    }

    public static char OctAscii(String oct) {
        int dec = Integer.parseInt(oct, 8);
        char text = (char) dec;
        return text;
    }



    // Hexadecimal to -> ...
    public static int HexDec(String hex) {
        int dec = Integer.parseInt(hex, 16);
        return dec;
    }

    public static String HexBin(String hex) {
        int dec = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(dec);
        return bin;
    }

    public static String HexOct(String hex) {
        int dec = Integer.parseInt(hex, 16);
        String oct = Integer.toOctalString(dec);
        return oct;
    }

    public static char HexAscii(String hex) {
        int dec = Integer.parseInt(hex, 16);
        char text = (char) dec;
        return text;
    }



    // ASCII to -> ...
    public static int AsciiDec(String ascii) {
        char text = ascii.charAt(0);
        int dec = (int) text;
        return dec;
    }

    public static String AsciiBin(String ascii) {
        char text = ascii.charAt(0);
        String bin = Integer.toBinaryString(text);
        return bin;
    }

    public static String AsciiOct(String ascii) {
        char text = ascii.charAt(0);
        String oct = Integer.toOctalString(text);
        return oct;
    }

    public static String AsciiHex(String ascii) {
        char text = ascii.charAt(0);
        String hex  = Integer.toHexString(text);
        return hex;
    }
}
