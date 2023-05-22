import java.util.Arrays;

public class FirstCheckerAndChoseFormat {

    private String[] inputArray;
    private String[] onlyNumbersArray = new String[2];
    private String[] romenNumbers = {"I", "V", "X"};

    FirstCheckerAndChoseFormat(String[] input) throws ErrorException {
        this.inputArray = input;
        firstConditionCheck();
    }

    // ПРОВЕРКА ВВОДА ЧЕРЕЗ ПРОБЕЛ
    private void firstConditionCheck() throws ErrorException {
        int arrayCount = (int) Arrays.stream(inputArray).count();

        if (arrayCount == 3) {
            onlyNumbersArray[0] = inputArray[0];
            onlyNumbersArray[1] = inputArray[2];
            numbersLanguageCheck();
        } else if (arrayCount > 3) {
            throw new ErrorException("Можно производить вычисления только с двумя числами");
        } else {
            throw new ErrorException("Строка не является математической операцией или необходимо расставить пробелы");
        }
    }

    // ПРОВЕРКА НА ФОРМАТ ЧИСЕЛ
    private void numbersLanguageCheck() throws ErrorException {
        int arabian = 0;
        int romen = 0;

        for (int i = 0; i < 2; i++) {

            String number = onlyNumbersArray[i];

            if (isArabianNumber(number)) {
                arabian += 1;
            } else {
                String romenNumber = Character.toString(number.toCharArray()[0]);
                if (Arrays.asList(romenNumbers).contains(romenNumber)) {
                    romen += 1;
                }
            }
        }

        if (arabian == 2) {
            ArabianCalculations arabianCalculations = new ArabianCalculations(inputArray, true);
        } else if (romen == 2) {
            RomenCalculations romenCalculations = new RomenCalculations(inputArray);
        } else if (arabian == 1 && arabian == romen) {
            throw new ErrorException("Вычисления необходимо проводить либо только с арабскими, либо только с римскими цифрами");
        } else {
            throw new ErrorException("Введены недопустимые символы");
        }
    }

    private boolean isArabianNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
