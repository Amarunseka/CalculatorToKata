public class Converter {
    public String arabicToRoman(int number) {

        String[] romanNumerals = {"M",  "CM",  "D",  "CD",  "C", "XC", "L",  "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues =    {1000,   900,  500,   400,  100,  90,   50,   40,   10,   9,   5,    4,   1};

        StringBuilder romanNumeral = new StringBuilder();
        int i = 0;

        while (number > 0) {
            if (number - arabicValues[i] >= 0) {
                romanNumeral.append(romanNumerals[i]);
                number -= arabicValues[i];
            } else {
                i++;
            }
        }

        System.out.println(romanNumeral.toString());
        return romanNumeral.toString();
    }

    public int romanToArabic(String romanNumber) {
        int result = 0;
        int lastValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char currentChar = romanNumber.charAt(i);
            int currentValue = romanCharToArabic(currentChar);

            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            lastValue = currentValue;
        }
        return result;
    }

    private int romanCharToArabic(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Некорректный символ римского числа: " + romanChar);
        }
    }
}
