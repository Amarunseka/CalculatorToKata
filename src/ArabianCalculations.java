public class ArabianCalculations {

    private boolean isArabian;
    private String[] inputNumbers;
    private int firstNumber;
    private int secondNumber;
    public int result;

    ArabianCalculations(String[] input, boolean isArabian) throws ErrorException {
        this.isArabian = isArabian;
        inputNumbers = input;
        areCorrectNumbersCheck();
    }

    // ПРОВЕРКА НА ЦЕЛОЧИСЛЕННЫЕ ЦИФРЫ
    private void areCorrectNumbersCheck() throws ErrorException {
        try {
            firstNumber = Integer.parseInt(inputNumbers[0]);
            secondNumber = Integer.parseInt(inputNumbers[2]);
            areCorrectNumbersValue();
        } catch (NumberFormatException nfe) {
            throw new ErrorException("Можно использовать только целые числа");
        }
    }

    // ПРОВЕРКА ДИАПАЗОНА ЧИСЕЛ
    private void areCorrectNumbersValue() throws ErrorException {
        if (firstNumber >= 1 && firstNumber <= 10 &&
                secondNumber >= 1 && secondNumber <= 10){
            isCorrectMathMark();
        } else throw new ErrorException("Можно использовать только числа от 1 до 10 включительно");
    }

    // ПРОВЕРКА МАТЕМАТИЧЕСКИХ ЗНАКОВ И ВЫПОЛНЕНИЕ УСЛОВИЯ
    void isCorrectMathMark() throws ErrorException {
        switch (inputNumbers[1]) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                if (isArabian == false && secondNumber > firstNumber)
                    throw new ErrorException("В римской системе исчислений нет отрицательных чисел");
                else {
                    result = firstNumber - secondNumber;
                }
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                throw new ErrorException("Можно производить только: сложение, вычитание, умножение или деление");
        }

        if (isArabian) {
            System.out.println(result);
        }
    }
}