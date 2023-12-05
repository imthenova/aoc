package bo;

public class Game_D2 {
    private int ID;
    private RoundInfo_D2[] roundInfo = new RoundInfo_D2[100];

    //get set
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public RoundInfo_D2[] getRoundInfo() {
        return roundInfo;
    }


    public Game_D2(String content) {
        for (int i = 0; i < 100; i++) {
            roundInfo[i] = new RoundInfo_D2();
        }
        //content="Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        String[] strs = content.split(":");
        ID = Integer.parseInt(strs[0].split(" ")[1]);
        String[] roundInfoStrs = strs[1].split(";");
        for (int i = 0; i < roundInfoStrs.length; i++) {
            String[] drawals = roundInfoStrs[i].split(",");
            for (int j = 0; j < drawals.length; j++) {
                String[] parts = drawals[j].trim().split(" ");
                String color = parts[1];
                String count = parts[0];
                if (color.equals("red")) {
                    roundInfo[i].setRed(Integer.parseInt(count));
                } else if (color.equals("blue")) {
                    roundInfo[i].setBlue(Integer.parseInt(count));
                } else if (color.equals("green")) {
                    roundInfo[i].setGreen(Integer.parseInt(count));
                } else {
                    System.out.println("error");
                }
            }
        }

    }

    public int validate() {
        //loop round
        for (int i = 0; i < 100; i++) {
            RoundInfo_D2 round = roundInfo[i];
            int red = round.getRed();
            int blue = round.getBlue();
            int green = round.getGreen();
            if (red > 12 || blue > 14 || green > 13) {
                return 0;
            }
        }
        return getID();
    }

    public int highestNumber() {
        //get highest red *  highest blue *  highest green
        int highestRed = 0;
        int highestBlue = 0;
        int highestGreen = 0;
        for (int i = 0; i < 100; i++) {
            RoundInfo_D2 round = roundInfo[i];
            int red = round.getRed();
            int blue = round.getBlue();
            int green = round.getGreen();
            if (red > highestRed) {
                highestRed = red;
            }
            if (blue > highestBlue) {
                highestBlue = blue;
            }
            if (green > highestGreen) {
                highestGreen = green;
            }
        }
        return highestRed * highestBlue * highestGreen;
    }
}


