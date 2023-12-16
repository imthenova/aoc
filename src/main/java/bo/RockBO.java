package bo;

import aoc2022.D17;

import static aoc2022.D17.INDEX;
import static aoc2022.D17.ROCK_LIST;

public class RockBO {
    int[][] position;

    public void init() {
        int base = findBase();
        int[][] rock = findRock();
        position = new int[rock.length+base][7];
        for (int i = 0; i < rock.length; i++) {
            for (int j = 0; j < rock[i].length; j++) {
                position[i+base][j] = rock[i][j];
            }
        }
    }

    public int findBase() {
        for (int i = D17.ROCK_MAP.length - 1; i >= 0; i--) {
            for (int j = 0; j < D17.ROCK_MAP[i].length; j++) {
                if (D17.ROCK_MAP[i][j] != 0) {
                    return i + 4;
                }
            }
        }
        return -1 + 4;
    }

    public int[][] findRock() {
        int[][] rock = ROCK_LIST.get(INDEX);
        INDEX++;
        if (INDEX >= 6) {
            INDEX = 0;
        }
        return rock;
    }
    public void fall(){
        int[][] nextPosition = new int[position.length][7];
        for (int i = 1; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                nextPosition[i-1][j] = position[i][j];
            }
        }
        position = nextPosition;
    }


    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }
}
