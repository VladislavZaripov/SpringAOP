package advices;

public class Error {

    public void throwException() throws Exception{
        throw new Exception("Exception");
    }

    public void throwIllegalArgumentException() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalArgumentException");

    }
}