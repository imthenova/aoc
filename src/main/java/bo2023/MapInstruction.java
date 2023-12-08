package bo2023;


import java.util.Map;

public class MapInstruction {
    private String L;
    private String R;
    private String name;
    private Map<String, MapInstruction> map;
    private boolean arrive = false;

    public String getL() {
        return L;
    }

    public void setL(String l) {
        L = l;
    }

    public String getR() {
        return R;
    }

    public void setR(String r) {
        R = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, MapInstruction> getMap() {
        return map;
    }

    public void setMap(Map<String, MapInstruction> map) {
        this.map = map;
    }

    public void setArrive(boolean arrive) {
        this.arrive = arrive;
    }

    public boolean isArrive() {
        return arrive;
    }

    public MapInstruction(String name, String L, String R, Map<String, MapInstruction> map) {
        this.name = name;
        this.L = L;
        this.R = R;
        this.map = map;
    }

    public MapInstruction move(char instraction) {
//        System.out.println(this+" "+instraction);
        if (name.charAt(2) == 'Z') {
            arrive = true;
        } else {
            arrive = false;
        }
        if (instraction == 'L') {
            return map.get(L);
        } else {
            return map.get(R);
        }
    }

    public String toString() {
        return name + " " + L + " " + R;
    }
}
