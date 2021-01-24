package Repository;

public class ExceptionRepository extends RuntimeException
{
    public ExceptionRepository() {}

    public ExceptionRepository(String message)
    {
        super(message);
    }

    public ExceptionRepository(Exception exception)
    {
        super(exception);
    }
}
