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
        return this.factorial(n) / (this.factorial(r) * this.factorial(n - r));
    }

}
