package KI.Kulyk.Lab5;

public class Function
{
    public static double calculate(double x) throws CalcException
    {
        double y = 0;

        try
        {
            y = Math.sin(x) /  (1 / Math.tan(8 * x));
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }

        return y;
    }
}