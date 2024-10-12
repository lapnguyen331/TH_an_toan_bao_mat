package mahoadichchuyen;

// genKey : tạo key
//    loadKey : cho phép nhập key/chuyền key
//    encrypt : mã hoá với key
//    decrypt : giải mã

import java.util.Arrays;
import java.util.Random;

public class Mahoadichchuyen {
    int key ;
    char[]conven = {'a','b','c','d','e',
            'f','g','h','i',
            'j','k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x'
            ,'y','n','z'};

    public int genKey(){
        Random ran = new Random();
        return Math.round(ran.nextInt(24));
    }
    public void loadKey(){
        key= genKey();
    }
    public String encrypt(String inputText, char[] conversionTable){
        char[] temp = inputText.toCharArray();
        char[] result = temp.clone();
        for (int i =0; i < temp.length; i++) {
            for(int y =0 ; y < conversionTable.length; y++){
                if(temp[i] == conversionTable[y]){
                    if( (y + key) / conversionTable.length > 0){
                        int com =  (y +key) % conversionTable.length;
                        result[i] = conversionTable[com ];
                    }
                    else {
                        result[i] = conversionTable[y + key];

                    }
                }

            }
        }
        return String.valueOf(result);
    }
    public void decrypt (String input){

    }
    public static void main(String[] args) {
        Mahoadichchuyen t = new Mahoadichchuyen();
        t.loadKey();
        System.out.println("key: " + t.key);
        System.out.println("result encrypt: "+ t.encrypt("da",t.conven));
    }
}
