package com.bingo.plate;

import java.util.Arrays;
import java.util.Random;

public class PlateNumber {
  private int numberOne;
  private int numberTwo;
  private int numberThree;
  private Random random = new Random();
  private int[][] numberPlace = new int[3][9];
  private int numberNull = 00;
  private final int NUMBERS_IN_ROW = 5;
  private int place = 0;

  public PlateNumber() {
  }

  //getter

  public int[][] getNumberPlace() {
    generateNumber();
    return numberPlace;
  }

  //setter


  //Method
  public void generateNumber() {

    //for (int i = 0; i < numberPlace.length; i++) { // 3
    for (int j = 0; j < numberPlace[0].length; j++) { // 9
      setNumber(j);
      if (j == 0) {
        numberPlace[0][j] = numberOne + 1;
        numberPlace[1][j] = numberTwo + 1;
        numberPlace[2][j] = numberThree + 1;
      } else {
        numberPlace[0][j] = numberOne;
        numberPlace[1][j] = numberTwo;
        numberPlace[2][j] = numberThree;
      }


    }
    // }

    //sorting
    for (int j = 0; j < numberPlace[0].length; j++) {
      sortArray(j, numberPlace);
    }

    removeNumbers();

  }

  private void sortArray(int collum, int[][] array) {

    int[] arr = new int[3];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = array[i][collum];
    }
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      array[i][collum] = arr[i];
    }

  }


  private void setNumber(int diff) {

    this.numberOne = random.nextInt(9) + diff * 10;
    this.numberTwo = random.nextInt(9) + diff * 10;
    while (numberOne == numberTwo) {
      this.numberTwo = random.nextInt(9) + diff * 10;
    }

    this.numberThree = random.nextInt(9) + diff * 10;
    while (numberTwo == numberThree || numberOne == numberThree) {
      this.numberThree = random.nextInt(9) + diff * 10;
    }

  }

  private void removeNumbers() {
    final int NUMBERS_REMOVED = 4;

    for (int i = 0; i < numberPlace.length; i++) {
      for (int j = 0; j < NUMBERS_REMOVED; j++) {
        int randomNumber = random.nextInt(numberPlace[0].length);

        while (numberPlace[i][randomNumber] == 0) {
          randomNumber = random.nextInt(numberPlace[0].length);
        }
        while (numberPlace[0][randomNumber] == 0 && numberPlace[1][randomNumber] == 0) {
          randomNumber = random.nextInt(numberPlace[0].length);
        }

        numberPlace[i][randomNumber] = 0;

      }
    }

  }

}
