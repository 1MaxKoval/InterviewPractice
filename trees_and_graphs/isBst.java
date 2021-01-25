package trees_and_graphs;

import java.util.*;
public class isBst {
    //86, 113, 128
    public static boolean bst(MyBinaryNode rootNode, Integer[] range) {
        if (rootNode == null) {
            return true;
        }

        Integer[] rangeForLeft = range.clone();
        Integer[] rangeForRight = range.clone();
        rangeForLeft[1] = rootNode.val;
        rangeForRight[0] = rootNode.val;


        if (range[0] == null && range[1] == null) {
            boolean leftRes = bst(rootNode.left, rangeForLeft);
            boolean rightRes = bst(rootNode.right, rangeForRight);
            return leftRes && rightRes;
        }

        //pass left
        if (range[0] == null) {
            if (!(rootNode.val <= range[1])) return false;
        }
        //pass right 
        else if (range[1] == null) {
            if (!(rootNode.val > range[0])) return false;
        }
        else {
            if (!(rootNode.val<=range[1] && rootNode.val>range[0])) return false;
        }
        
        boolean leftRes = bst(rootNode.left, rangeForLeft);
        boolean rightRes = bst(rootNode.right, rangeForRight);

        return leftRes&&rightRes;
    } 

}
