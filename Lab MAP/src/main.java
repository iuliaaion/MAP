public class main {
    public static void main(String[] args)
    {
        int sum = 0;
        int n = args.length;

        for(int i=0;i<n;i++)
        {
            sum = sum + Integer.parseInt(args[i]);
        }

        System.out.println("Sum: " + sum);

    }
}
