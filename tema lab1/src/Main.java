public class Main {

    public static void main(String[] args)
    {
        /* cmmmc of two integer numbers given as command-line parameters */

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int x = a;
        int y = b;


        while (x != y)
            {
                if(x > y)
                    x = x-y;
                else
                    y = y-x;
            }


        System.out.println("cmmdc = " + (a*b)/x);
    }

    }

