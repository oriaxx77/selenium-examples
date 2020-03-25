package com.oriaxx77.seleniumplay;

@FunctionalInterface
interface IOMethod
{
    void execute() throws Exception;
}

public class IO
{
    private IOMethod ioMethod;
    public IO(IOMethod ioMethod){this.ioMethod = ioMethod;}

    public void execUnsafe()
    {
        try { this.ioMethod.execute(); }
        catch( Exception e ) {throw new RuntimeException(e);}
    }

}
