package bo;

public class InventoryBO {
    int oreRobot = 1;
    int clayRobot;
    int obsidianRobot;
    int geodeRobot;

    int ore;
    int clay;
    int obsidian;
    int geode;

    public void collect() {
        ore += oreRobot;
        clay += clayRobot;
        obsidian += obsidianRobot;
        geode += geodeRobot;
    }
    public void buildRobot(BluePrintBO bluePrintBO){
        //make geodeRobot
        if(obsidian>=bluePrintBO.getGeodeRobotObsidianCost() && ore>=bluePrintBO.getGeodeRobotOreCost()){
            geodeRobot++;
            obsidian-=bluePrintBO.getGeodeRobotObsidianCost();
            ore-=bluePrintBO.getGeodeRobotOreCost();
        }
    }
}
