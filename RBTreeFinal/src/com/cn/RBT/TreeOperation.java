package com.cn.RBT;

/******************************
 *
 * 鐮佺偒璇惧爞鎶�鏈氦娴丵缇わ細963060292
 * 涓昏锛歴mart鍝�
 *
 ******************************/
public class TreeOperation {
    /*
    鏍戠殑缁撴瀯绀轰緥锛�
              1
            /   \
          2       3
         / \     / \
        4   5   6   7
    */

    // 鐢ㄤ簬鑾峰緱鏍戠殑灞傛暟
    public static int getTreeDepth(RBTree.RBNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.getLeft()), getTreeDepth(root.getRight())));
    }


    private static void writeArray(RBTree.RBNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 淇濊瘉杈撳叆鐨勬爲涓嶄负绌�
        if (currNode == null) return;
        // 0銆侀粯璁ゆ棤鑹�
//       res[rowIndex][columnIndex] = String.valueOf(currNode.getValue());
        //1銆侀鑹茶〃绀�
        if(currNode.isColor()){//榛戣壊锛屽姞鑹插悗閿欎綅姣旇緝鏄庢樉
                res[rowIndex][columnIndex] = ("\033[30;3m" + currNode.getValue()+"\033[0m") ;
        }else {
                res[rowIndex][columnIndex] = ("\033[31;3m" + currNode.getValue()+"\033[0m") ;
        }
        //2銆丷,B琛ㄧず
//        res[rowIndex][columnIndex] = String.valueOf(currNode.getValue()+"-"+(currNode.isColor()?"B":"R")+"");

        // 璁＄畻褰撳墠浣嶄簬鏍戠殑绗嚑灞�
        int currLevel = ((rowIndex + 1) / 2);
        // 鑻ュ埌浜嗘渶鍚庝竴灞傦紝鍒欒繑鍥�
        if (currLevel == treeDepth) return;
        // 璁＄畻褰撳墠琛屽埌涓嬩竴琛岋紝姣忎釜鍏冪礌涔嬮棿鐨勯棿闅旓紙涓嬩竴琛岀殑鍒楃储寮曚笌褰撳墠鍏冪礌鐨勫垪绱㈠紩涔嬮棿鐨勯棿闅旓級
        int gap = treeDepth - currLevel - 1;
        // 瀵瑰乏鍎垮瓙杩涜鍒ゆ柇锛岃嫢鏈夊乏鍎垮瓙锛屽垯璁板綍鐩稿簲鐨�"/"涓庡乏鍎垮瓙鐨勫��
        if (currNode.getLeft() != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.getLeft(), rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 瀵瑰彸鍎垮瓙杩涜鍒ゆ柇锛岃嫢鏈夊彸鍎垮瓙锛屽垯璁板綍鐩稿簲鐨�"\"涓庡彸鍎垮瓙鐨勫��
        if (currNode.getRight() != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.getRight(), rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(RBTree.RBNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 寰楀埌鏍戠殑娣卞害
        int treeDepth = getTreeDepth(root);

        // 鏈�鍚庝竴琛岀殑瀹藉害涓�2鐨勶紙n - 1锛夋鏂逛箻3锛屽啀鍔�1
        // 浣滀负鏁翠釜浜岀淮鏁扮粍鐨勫搴�
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 鐢ㄤ竴涓瓧绗︿覆鏁扮粍鏉ュ瓨鍌ㄦ瘡涓綅缃簲鏄剧ず鐨勫厓绱�
        String[][] res = new String[arrayHeight][arrayWidth];
        // 瀵规暟缁勮繘琛屽垵濮嬪寲锛岄粯璁や负涓�涓┖鏍�
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 浠庢牴鑺傜偣寮�濮嬶紝閫掑綊澶勭悊鏁翠釜鏍�
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/2, res, treeDepth);

        // 姝ゆ椂锛屽凡缁忓皢鎵�鏈夐渶瑕佹樉绀虹殑鍏冪礌鍌ㄥ瓨鍒颁簡浜岀淮鏁扮粍涓紝灏嗗叾鎷兼帴骞舵墦鍗板嵆鍙�
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
