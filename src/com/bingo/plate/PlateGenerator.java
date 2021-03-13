package com.bingo.plate;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PlateGenerator {
  private final Random random = new Random();
  private final PlateNumber plateNumber = new PlateNumber();
  private final Scanner scanner = new Scanner(System.in);
  private String blackColor = "\033[30m";
  private String underLine = "\033[4m";
  private String middleLine = "\033[9m";
  private String greenNumber= "\033[32m";
  private String end = "\033[0m";
  private int[][] plateNumbers = plateNumber.getNumberPlace();

  private int[] rowOne = new int[5];
  private int[] rowTwo = new int[5];
  private int[] rowThree = new int[5];

  private int[] numbersOnBingo = new int[90];

  //int[][] plateNumbers = plateNumber.getNumberPlace();

  public PlateGenerator() {
  }

  //getter
  public int[][] getPlateNumbers() { return  this.plateNumbers; }
  public int[] getNumbersOnBingo() { return this.numbersOnBingo; }


  //setter
  public void setNumbersOnBingo (int[] numbersOnBingo) {
    this.numbersOnBingo = numbersOnBingo;
  }


  //method
  public void generatePlate() {

    for (int i = 0; i < plateNumbers.length; i++) {
      for (int j = 0; j < plateNumbers[i].length; j++) {
        if (j == 0) {
          if (plateNumbers[i][j] == 0) {
            System.out.print("|" + underLine + "  ");
          } else {
            System.out.print("|" + underLine + 0 + plateNumbers[i][j]);
          }
        } else {
          if (plateNumbers[i][j] == 0) {
            System.out.print("|" + underLine + "  ");
          } else {
            System.out.print("|" + underLine + plateNumbers[i][j]);
          }
        }
        if (j == plateNumbers[i].length - 1) {
          System.out.print(end + "|");
          System.out.println();
        }
      }
    }

  }

  public void numbersTaken(int number) {

    if (number < 1 || number > 90) {
      System.out.println( number + " is not correct.");
    }
    for (int i = 0; i < numbersOnBingo.length + 1; i++) {
      if (i == number) {
        numbersOnBingo[i - 1] = number;
      }
    }
    // System.out.println(Arrays.toString(getNumbersOnBingo()));
    setNumbersOnBingo(numbersOnBingo);
  }

  public boolean checkForBingoOneRow() {
    if (checkForFirstRow()) {
      //System.out.println("Bingo in first row!!");
      return true;
    } else if (checkForSecondRow()) {
      //System.out.println("Bingo in second row!!");
      return true;
    } else if (checkForThirdRow()) {
      //System.out.println("Bingo in third row!!");
      return true;
    }

    return false;
  }

  public void checkForBingoOneRowPrint() {

    rowsWithoutZero();

    if (checkForFirstRow()) {
      //System.out.println("Bingo in first row!!");
      System.out.println(greenNumber + Arrays.toString(rowOne) + end);
    } else if (checkForSecondRow()) {
      //System.out.println("Bingo in second row!!");
      System.out.println(greenNumber + Arrays.toString(rowTwo) + end);
    } else if (checkForThirdRow()) {
      //System.out.println("Bingo in third row!!");
      System.out.println(greenNumber + Arrays.toString(rowThree) + end);
    }
  }

  public boolean checkForBingTwoRows() {
    if (checkForFirstRow() && checkForSecondRow()) {
      //System.out.println("Bingo in first and second row!!");
      return true;
    } else if (checkForSecondRow() && checkForThirdRow()) {
      //System.out.println("Bingo in second and third row!!");
      return true;
    } else if (checkForThirdRow() && checkForFirstRow()) {
      //System.out.println("Bingo in first and third row!!");
      return true;
    }

    return false;
  }

  public void checkForBingTwoRowsPrint() {

    rowsWithoutZero();

    if (checkForFirstRow() && checkForSecondRow()) {
      //System.out.println("Bingo in first and second row!!");
      System.out.println(greenNumber + Arrays.toString(rowOne) + end);
      System.out.println(greenNumber + Arrays.toString(rowTwo) + end);
    } else if (checkForSecondRow() && checkForThirdRow()) {
      //System.out.println("Bingo in second and third row!!");
      System.out.println(greenNumber + Arrays.toString(rowTwo) + end);
      System.out.println(greenNumber + Arrays.toString(rowThree) + end);
    } else if (checkForThirdRow() && checkForFirstRow()) {
      //System.out.println("Bingo in first and third row!!");
      System.out.println(greenNumber + Arrays.toString(rowOne) + end);
      System.out.println(greenNumber + Arrays.toString(rowThree) + end);
    }
  }

  public boolean checkForBingoThreeRows() {
    if (checkForFirstRow() && checkForSecondRow() && checkForThirdRow()) {
      return true;
    }
    return false;
  }

  public void checkForBingThreeRowsPrint() {

    rowsWithoutZero();

    if (checkForThirdRow()) {
      //System.out.println("Bingo in first and second row!!");
      System.out.println(greenNumber + Arrays.toString(rowOne) + end);
      System.out.println(greenNumber + Arrays.toString(rowTwo) + end);
      System.out.println(greenNumber + Arrays.toString(rowThree) + end);
    }
  }

  public boolean checkForFirstRow() {
    int[] firstRow = new int[5];
    int numbersCheck = 0;
    int rowNumber = 0;

      for (int j = 0; j < plateNumbers[0].length; j++) {
        if (plateNumbers[0][j] != 0) {
          firstRow[rowNumber] = plateNumbers[0][j];
          rowNumber++;
        }
      }

    for (int k : firstRow) {
      for (int onBingo : numbersOnBingo) {
        if (k == onBingo) {
          numbersCheck++;
        }
      }
    }

    if (numbersCheck == 5) {
      return true;
    }

    return false;
  }

  public boolean checkForSecondRow() {
    int[] secondRow = new int[5];
    int numbersCheck = 0;
    int rowNumber = 0;

    for (int j = 0; j < plateNumbers[1].length; j++) {
      if (plateNumbers[1][j] != 0) {
        secondRow[rowNumber] = plateNumbers[1][j];
        rowNumber++;
      }
    }

    for (int k : secondRow) {
      for (int onBingo : numbersOnBingo) {
        if (k == onBingo) {
          numbersCheck++;
        }
      }
    }

    if (numbersCheck == 5) {
      return true;
    }

    return false;
  }

  public boolean checkForThirdRow() {
    int[] thirdRow = new int[5];
    int numbersCheck = 0;
    int rowNumber = 0;

    for (int j = 0; j < plateNumbers[2].length; j++) {
      if (plateNumbers[2][j] != 0) {
        thirdRow[rowNumber] = plateNumbers[2][j];
        rowNumber++;
      }
    }

    for (int k : thirdRow) {
      for (int onBingo : numbersOnBingo) {
        if (k == onBingo) {
          numbersCheck++;
        }
      }
    }

    if (numbersCheck == 5) {
      return true;
    }

    return false;
  }

  public void rowsWithoutZero() {

    int counter = 0;

    for (int i = 0; i < plateNumbers[0].length; i++) {
      if (plateNumbers[0][i] != 0) {
        rowOne[counter] = plateNumbers[0][i];
        counter++;
      }
    }
    counter = 0;

    for (int i = 0; i < plateNumbers[1].length; i++) {
      if (plateNumbers[1][i] != 0) {
        rowTwo[counter] = plateNumbers[1][i];
        counter++;
      }
    }
    counter = 0;

    for (int i = 0; i < plateNumbers[2].length; i++) {
      if (plateNumbers[2][i] != 0) {
        rowThree[counter] = plateNumbers[2][i];
        counter++;
      }
    }
  }


}
