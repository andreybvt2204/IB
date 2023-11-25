public class Ib_4 {
    public static void main(String[] args){
        System.out.println("а = 9, b = 11, с = МахVal + 1 = 256, t0 = 201\n");

        System.out.print("Р = '021345', KSum: " + checksumMethod("021345"));
        System.out.println(", SummKodBukvOtkr: " + hashingMethodUsingGamming("021345"));

        System.out.print("Р = '543120', KSum: " + checksumMethod("543120"));
        System.out.println(", SummKodBukvOtkr: " + hashingMethodUsingGamming("543120"));

        System.out.print("Р = '1000999', KSum: " + checksumMethod("1000999"));
        System.out.println(", SummKodBukvOtkr: " + hashingMethodUsingGamming("1000999"));

        System.out.print("Р = '1999000', KSum: " + checksumMethod("1999000"));
        System.out.println(", SummKodBukvOtkr: " + hashingMethodUsingGamming("1999000"));
    }

    private static int checksumMethod(String P) {
        int c = 256;
        int sum = 0;
        for (int i = 0; i < P.length(); i++) {
            sum += P.charAt(i);
        }
        if (sum <= c) return sum;
        return sum % c;
    }

    private static int hashingMethodUsingGamming(String P){
        int a = 9, b = 11, c = 256, t0 = 201;
        int sum = 0;
        int[] t = new int[P.length()];
        for (int i = 0; i < P.length(); i++) {
            if (i == 0) t[i] = t0;
            else t[i] = (a * t[i - 1] + b) % c;
            sum += P.charAt(i) ^ t[i];
        }
        return sum % c;
    }
}
