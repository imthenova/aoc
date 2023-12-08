package bo;

import java.util.ArrayList;
import java.util.List;

public class NumberPosition_D3 {
    private int value;
    private boolean adjacentToASymbol;
    private List<String> positionList = new ArrayList<>();
    private char[][] map;

    public NumberPosition_D3(char[][] map) {
        this.map = map;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<String> getPositionList() {
        return positionList;
    }

    public boolean isAdjacentToASymbol() {
        return adjacentToASymbol;
    }

    public void setAdjacentToASymbol(boolean adjacentToASymbol) {
        this.adjacentToASymbol = adjacentToASymbol;
    }

    public void checkListSurrounding(){
        for (String position : positionList) {
            if(position.equals("94,137")){
            }
            String[] positionArray = position.split(",");
            int x = Integer.parseInt(positionArray[0]);
            int y = Integer.parseInt(positionArray[1]);
            checkPositionSurrounding(x,y);
        }
    }
    private void checkPositionSurrounding(int x, int y) {
        String allowString = "0123456789.\r\n";
        for (int i = Math.max(0, x-1); i <= Math.min(map.length - 1, x + 1); i++) {
            for (int j = Math.max(0, y-1); j <= Math.min(map[i].length - 1, y + 1); j++) {
                if (i == x && y == j) {
                    continue;
                }
                if (allowString.indexOf(map[i][j]) == -1) {
                    adjacentToASymbol = true;
                }
            }

        }
    }
}
