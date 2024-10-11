package programs;

public class AddLargeNumbers {
    static String addStrings(String num1, String num2) {
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        Integer carry = 0;
        while(index1>=0 || index2>=0) {
            Integer a = 0;
            Integer b = 0;
            if(index1>=0) {
                a = Integer.valueOf(String.valueOf(num1.charAt(index1)));
                index1--;
            }
            if(index2>=0) {
                b = Integer.valueOf(String.valueOf(num2.charAt(index2)));
                index2--;
            }
            Integer sum = a + b + carry;
            if(sum>9) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        System.out.println(addStrings(num1, num2));
    }
}
