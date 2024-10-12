package mahoathaythe;

import java.util.Random;

public class Mahoathaythe {
    String key ;
    char[]conven = {'a','b','c','d','e',
            'f','g','h','i',
            'j','k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x'
            ,'y','n','z'};

    public String genKey(int keyLength){
        Random ran = new Random();
        char [] keyString = new char[keyLength];
        for (int i = 0; i < keyLength; i++) {
            int index = ran.nextInt(0,24);
            keyString[i] = conven[index];
        }
        key = keyString.toString();
        return keyString.toString();
    }
    public void loadKey(){
//        key = genKey(5);
    }
    public void encrypt(String input, char[] conven){
        char[] in = input.toCharArray();
        for(int i =0 ; i < in.length ; i++){
            for(int y =0 ; y < conven.length ; y++){

            }
        }

    }
    public static void main(String[] args) {
        Mahoathaythe m = new Mahoathaythe();
        System.out.println("key: " + m.genKey(5));


    }

}
