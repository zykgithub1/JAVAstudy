package com.cn.RBT;

import java.util.Scanner;

/******************************
 *
 * é®ä½ºåçæ§çé¶ï¿½éîæ°¦å¨´ä¸µç¼ãç´°963060292
 * æ¶æîéæ­´martéï¿½
 *
 ******************************/
public class RBTreeTest {
    public static void main(String[] args) {
        //éæ¿îéºåå£
        insertOpt();
        //éç»æ«éºåå£
        //deleteOpt();
    }

    /**
     * é»æåé¿å¶ç¶
     */
    public static void insertOpt(){
        Scanner scanner=new Scanner(System.in);
        RBTree<String,Object> rbt=new RBTree<>();
        while (true){
            System.out.println("çç¯ç·­éã¤ç¶çä½¹å½éã§æ®éºåå£:");
            String key=scanner.next();
            System.out.println();
            rbt.put(key.length()==1?("0"+key):key,null);
            TreeOperation.show(rbt.getRoot());
        }
    }

    /**
     * éç»æ«é¿å¶ç¶
     */
    public static void deleteOpt(){
        RBTree<String,Object> rbt=new RBTree<>();
        //æ£°å«åé«ï¿½10æ¶îå¦­éç¸ç´1-10éï¿½
        for (int i = 1; i <11 ; i++) {
            rbt.put((i+"").length()==1?"0"+i:i+"",null);
        }
        TreeOperation.show(rbt.getRoot());
        //æµ ã¤ç¬å¯®ï¿½æ¿®å¬ªå¹éï¿½
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("çç¯ç·­éã¤ç¶çä½¸å¹éãæ®éºåå£:");
            String key=scanner.next();
            System.out.println();
            rbt.remove(key.length()==1?"0"+key:key);
            TreeOperation.show(rbt.getRoot());
        }
    }
}
