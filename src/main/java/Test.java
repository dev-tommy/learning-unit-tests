public class Test {
    public static void main(String[] args) {
        testCalcAdd();

    }

    private static void testCalcAdd() {
        Calc calc = new Calc();

        int result = calc.sum(2,2);

        if (result != 4) {
            throw  new IllegalStateException(ConsoleColors.RED_UNDERLINED + "Wrong" +
                    " result 2 + 2 is not 4" + ConsoleColors.RESET);
        } else {
            System.out.println("Sum "+ ConsoleColors.GREEN + "OK" + ConsoleColors.RESET);
        }
    }
}
