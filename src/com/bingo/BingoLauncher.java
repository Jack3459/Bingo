package com.bingo;

import com.bingo.plate.PlateGenerator;

import java.util.Scanner;

public class BingoLauncher {

  public static PlateGenerator plateGenerator = new PlateGenerator();
  public static Scanner scanner = new Scanner(System.in);
  private static int bingoNumber;
  private static String greenText = "\033[32m";
  private static String end = "\033[0m";

  public static void main(String[] args) {
    plateBingoCheck();


  }

  public static void plateBingoCheck(){
    int oneRow = 0;
    int twoRows = 0;
    int threeRows = 0;


    do {
      plateGenerator.generatePlate();
      callNumber();
      plateGenerator.numbersTaken(bingoNumber);

      if (plateGenerator.checkForBingoOneRow() && oneRow == 0) {
        //plateGenerator.checkForBingoOneRow();
        System.out.println(greenText + "Bingo in one row!" + end);
        plateGenerator.checkForBingoOneRowPrint();
        oneRow++;
      }

      if (plateGenerator.checkForBingTwoRows() && twoRows == 0) {
        //plateGenerator.checkForBingTwoRows();
        System.out.println(greenText + "Bingo in two rows!" + end);
        plateGenerator.checkForBingTwoRowsPrint();
        twoRows++;
      }

      if (plateGenerator.checkForBingoThreeRows() && threeRows == 0) {
        System.out.println(greenText + "!!BINGO!!!" + end);
        plateGenerator.checkForBingThreeRowsPrint();
        threeRows++;
      }

      System.out.print("\033[H\033[2J");
      System.out.flush();

    } while (true);
  }

  public static void callNumber() {
    System.out.print("Enter bingo number >: ");
    bingoNumber = scanner.nextInt();
  }


}
