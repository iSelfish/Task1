package com.company;

/*1. В бинарном массиве(запонен 0 и 1) N*N содержиться несколько прямоугольников. Различные прямоугольники не
соприкасаются и не накладываются. Внутри прямоугольник весь заполнен 1. В массиве: a[i, j] = 1, если элемент (i, j)
принадлежит какому-либо прямоугольнику a[i, j] = 0, если нет. Посчитать количество прямоугольников.
Вариант 1: массив задан в коде
Вариант 2: массив считывать из файла*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Chose option\nOption 1: array from code\nOption 2: array from file");

        int option = in.nextInt();
        Integer[][] arr;
        if (option == 1) {
            arr = new Integer[][]{
                    {1, 1, 1, 0, 0, 1},
                    {1, 1, 1, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 1, 1, 1},
                    {1, 1, 0, 1, 1, 1},
                    {0, 0, 0, 1, 1, 1}};
        } else if (option == 2) {
            BufferedReader br = new BufferedReader(new FileReader("array.txt"));

            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            int arrWidth = lines.get(0).split(" ").length;
            int arrHeight = lines.size();

            arr = new Integer[arrHeight][arrWidth];

            for (int i = 0; i < arrHeight; i++) {
                for (int j = 0; j < arrWidth; j++) {
                    String[] line = lines.get(i).split(" ");
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        } else {
            System.out.println("Wrong option");
            arr = new Integer[0][];
            System.exit(0);
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    int startI = i;
                    int startJ = j;
                    while (i < arr.length) {
                        if (arr[i][j] == 0) break;
                        i++;
                    }
                    i--;
                    while (j < arr.length) {
                        if (arr[i][j] == 0) break;
                        j++;
                    }
                    j--;
                    for (int l = startI; l <= i; l++)
                        for (int k = startJ; k <= j; k++)
                            arr[l][k] = 0;
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }
}

