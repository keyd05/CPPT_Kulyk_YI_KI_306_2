package KI.Kulyk.Lab5;

/**
 * Class <code>Functions</code> implements method for (sin(x) / ctg(8x)) expression
 * calculation
 * @version 1.0
 */
public class Function {
    /**
     * Method calculates the (sin(x) / ctg(8x)) expression*
     * @param x Angle in degrees
     * @throw CalcException
     * @return result
     */
    public static double calculate(double x) throws CalcException {
        double y;
        double rad = x * Math.PI / 180.0;

        try {
            y = Math.sin(rad) /  (1 / Math.tan(8 * rad));

            // Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || x == 11.25 || x == -11.25)
                throw new ArithmeticException();
        }
        // створимо виключення вищого рівня з поясненням причини
        // виникнення помилки
        catch (ArithmeticException ex) {
            if (rad == Math.PI / 16.0 || rad == -Math.PI / 16.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }

        return y;
    }
}