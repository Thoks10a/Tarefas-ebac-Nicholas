package com.fatorial;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RecursaoFatorial recursaoFatorial = new RecursaoFatorial();
        System.out.println(recursaoFatorial.fatorial(3));

        ProgramacaoDinamica programacaoDinamica = new ProgramacaoDinamica();
        System.out.println(programacaoDinamica.fibonacci2(6));

        System.out.println(programacaoDinamica.product1ToN(7));

    }
}
