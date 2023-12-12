package bo2023;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CamelCardsJokerVersion implements Comparable<CamelCardsJokerVersion>{
    String hands;
    String handValues;
    int type;
    int bid;
    int rank;

    public void setRank(int rank) {
        this.rank = rank;
    }
    public BigInteger getScore(){
        BigInteger score = new BigInteger("0");
        score = score.add(new BigInteger(String.valueOf(rank)));
        score = score.multiply(new BigInteger(String.valueOf(bid)));
        return score;
    }
    public CamelCardsJokerVersion(String line){
        this.hands = line.split(" ")[0];
        this.handValues = hands.replace('A','z').replace("K","y").replace("Q","x").replace("J","0").replace("T","v");
        this.bid = Integer.parseInt(line.split(" ")[1]);
        //count char in hands
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = hands.toCharArray();
        int jCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!='J'){
                if(map.containsKey(chars[i])){
                    map.put(chars[i],map.get(chars[i])+1);
                }else{
                    map.put(chars[i],1);
                }
            }else{
                jCount++;
            }
        }

        //if map.value = 5, type = 7, means 5 of a kind;
        // if map.value = 4, type = 6, means 4 of a kind;
        // if map.value = 3 && map.key count = 2, type = 5, mean full house;
        // if map.value = 3, type = 4, means 3 of a kind;
        // if map.value = 2 && map.key count = 3, type = 3, mean 2 pairs;
        // if map.value = 2, type = 2, means 1 pair;
        // if map.value = 1, type = 1, means high card;
        // if map.value = 0, type = 0, means high card;
        int[] count = new int[6];
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            count[entry.getValue()-1]++;
        }
        //get the max count index
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                max = i;
            }
        }
        if(jCount>0){
            if (jCount==5){
                this.type = 7;
                return;
            }
            count[max+jCount] = 1;
            count[max] -= 1;
        }
        if(count[4]==1){//5 of a kind
            this.type = 7;
        }else if(count[3]==1){ //4 o a k
            this.type = 6;
        }else if(count[2]==1 && count[1]==1){ // full house
            this.type = 5;
        } else if (count[2]==1) {//3 of a kind
            this.type = 4;
        } else if (count[1]==2) { //2 pairs
            this.type = 3;
        } else if (count[1]==1) { //1 pair
            this.type = 2;
        } else if (count[0]==5) { //high card
            this.type = 1;
        } else {
            System.out.println("error");
        }


    }
    //compareTo
    @Override
    public int compareTo(CamelCardsJokerVersion other){
        if(this.type!=other.type){
            return this.type-other.type;
        }else{
            return this.handValues.compareTo(other.handValues);
        }
    }
    public String toString(){
        //hands bid type rank
        return hands+" "+bid+" "+type+" "+rank;
    }
}
