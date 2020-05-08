package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of keys:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=n+5;
        float p[]=new float[m];
        int kmin;
        System.out.println("Enter the key values:");
        for(int i=1;i<=n;i++)
        {
            p[i] = sc.nextFloat();
        }
        float C[][]= new float[m][m];
        float R[][]= new float[m][m];
        int j;
        float sum;
        for(int i=1;i<=n;i++){
            C[i][i-1]=0;
            C[i][i]=p[i];
            R[i][i]=0;
        }
        C[n+1][n]=0;
        for(int d=1;d<n;d++) {
            for (int i = 1; i < (n - d); i++) {
                j = i + d;
                Float minval = Float.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if ((C[i][k - 1] + C[k + 1][j]) < minval) {
                        minval = C[i][k - 1] + C[k + 1][j];
                        R[i][j]=k;
                    }
                    //R[i][j]=kmin;
                }

                sum = p[i];
                for (int s = i + 1; i <= j; s++) {
                    sum = sum + p[s];
                }
                C[i][j] = minval + sum;
            }
        }
        System.out.println(C[1][n]);
        System.out.println(R);

    }
}
