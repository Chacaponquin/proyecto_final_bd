/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

/**
 *
 * @author Jose
 */
public class UtilsSNB
{
    public int factorial(int r)
    {
        for (int i = r - 1; i > 0; i--)
        {
            r = r * i;
        }
        return r == 0 ? 1 : r;
    }

    public int comb(int n, int r)
    {
        return n * (n - 1) / this.factorial(r);
    }

    public static void main(String args[])
    {
        System.out.println(UtilsConnector.utilsSNB.comb(16, 2));
        System.out.println(UtilsConnector.utilsSNB.comb(8, 2));
        System.out.println(UtilsConnector.utilsSNB.comb(4, 2));
        System.out.println(UtilsConnector.utilsSNB.comb(2, 2));
    }
}
