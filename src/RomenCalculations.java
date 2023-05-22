
public class RomenCalculations {

    private String[] inputNumbers;
    private Converter converter = new Converter();
    RomenCalculations(String[] input) throws ErrorException {
        inputNumbers = input;
        doCalculation();
    }

    private void doCalculation() throws ErrorException {
        int numbers[] = convertToArabian();

        String[] outputArray = {Integer.toString(numbers[0]), inputNumbers[1], Integer.toString(numbers[1])};
        ArabianCalculations calculations = new ArabianCalculations(outputArray, false);

        String result = converter.arabicToRoman(calculations.result);
    }

    private int[] convertToArabian(){

        int resultArray[] = new int[2];
        resultArray[0] = converter.romanToArabic(inputNumbers[0]);
        resultArray[1] = converter.romanToArabic(inputNumbers[2]);

        return resultArray;
    }
}