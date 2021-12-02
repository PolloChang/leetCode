package leet.code;

import java.util.ArrayList;

public class Skiplist {
    private ArrayList<Node> nodeL;
    public Skiplist() {
        nodeL = new ArrayList<Node>();
    }
    private int count = 0;

    public boolean search(int target) {
        count ++;
        boolean returnVal = false;

        for(Node nodeI : nodeL){
            if(nodeI.search(target)){
                returnVal = true;
                break;
            }
        }
//        System.out.print(target+"["+count+"]search ;");
//        seeNodeL();
//        System.out.println("returnVal = "+returnVal);
        return returnVal;
    }

    public void add(int num) {
        count ++;
        if(nodeL.size() == 0){
            Node nodeI = new Node();
            nodeI.add(num);
            nodeL.add(nodeI);
        }else{

            boolean needAdd = false;

            for(int i = nodeL.size(); i > 0 ; i--){

                Node nodeI = nodeL.get(i-1);

                if(!nodeI.search(num)){
                    nodeI.add(num);
                    needAdd = false;
                    break;
                }else{
                    needAdd = true;
                }

            }

            if(needAdd){
                Node nodeI = new Node();
                nodeI.add(num);
                nodeL.add(nodeI);
            }
        }
//        System.out.print(num+"["+count+"]add ;");
//        seeNodeL();
//        System.out.println();
    }

    public boolean erase(int num) {
        count ++;
        boolean returnVal = false;
        for(int i = nodeL.size(); i > 0 ; i--){
            Node nodeI = nodeL.get(i-1);
            returnVal = nodeI.erase(num);
            if(returnVal){
                if(nodeI.dataL.size() == 0){
                    nodeL.remove(i-1);
                }
                break;

            }
        }

//        System.out.print(num+"["+count+"]erase ;nodeL.size() = "+nodeL.size());
//        seeNodeL();
//        System.out.println("returnVal = "+returnVal);
        return returnVal;
    }

    /**
     * 列印容器內容
     */
    private void seeNodeL(){
        for(Node nodeI : nodeL){
            System.out.print(nodeI.dataL);
        }
    }


    /**
     * 儲存記憶容器
     */
    class Node{
        private ArrayList<Integer> dataL = null;
        public Node() {
            dataL = new ArrayList<Integer>();
        }

        public boolean search(int target) {

            boolean returnVal = (dataL.contains(target));

            return returnVal;

        }

        public void add(int num) {
            if(!dataL.contains(num)){

                if(dataL.size() == 0){
                    dataL.add(num);
                }else{

                    for(int i =0 ; i < dataL.size() ; i++){

                        if(dataL.size() > i+1){
                            if(num < dataL.get(i)){
                                dataL.add(i,num);

                                break;
                            }
                            if(num > dataL.get(i) && num < dataL.get(i+1)){
                                dataL.add(i+1,num);

                                break;
                            }
                        }else{
                            dataL.add(num);

                            break;
                        }


                    }
                }
            }

        }

        public boolean erase(int num) {
            int setMap = 0;
            boolean returnVal = false;
            for(int dataI : dataL){
                if(num == dataI){
                    dataL.remove(setMap);
                    returnVal = true;
                    break;
                }
                setMap++;
            }
            return returnVal;

        }
    }

    /*
     * check functions
     * Skiplist skiplist = new Skiplist();
     *         skiplist.add(5);
     *         skiplist.add(14);
     *         skiplist.add(13);
     *         skiplist.add(0);
     *         skiplist.add(3);
     *         skiplist.add(12);
     *         skiplist.add(9);
     *         skiplist.add(12);
     *         skiplist.erase(3);
     *         skiplist.search(6);
     *         skiplist.add(7);
     *         skiplist.erase(0);
     *         skiplist.erase(1);
     *         skiplist.erase(10);
     *         skiplist.add(5);
     *         skiplist.search(12);
     *         skiplist.search(7);
     *         skiplist.search(16);
     *         skiplist.erase(7);
     *         skiplist.search(0);
     *         skiplist.add(9);
     *         skiplist.add(16);
     *         skiplist.add(3);
     *         skiplist.erase(2);
     *         skiplist.search(17);
     *         skiplist.add(2);
     *         skiplist.search(17);
     *         skiplist.erase(0);
     *         skiplist.search(9);
     *         skiplist.search(14);
     *         skiplist.erase(1);
     *         skiplist.erase(6);
     *         skiplist.add(1);
     *         skiplist.erase(16);
     *         skiplist.search(9);
     *         skiplist.erase(10);
     *         skiplist.erase(9);
     *         skiplist.search(2);
     *         skiplist.add(3);
     *         skiplist.add(16);
     *         skiplist.erase(15);
     *         skiplist.erase(12);
     *         skiplist.erase(7);
     *         skiplist.add(4);
     *         skiplist.erase(3);
     *         skiplist.add(2);
     *         skiplist.erase(1);
     *         skiplist.erase(14);
     *         skiplist.add(13);
     *         skiplist.add(12);
     *         skiplist.add(3);
     *         skiplist.search(6);
     *         skiplist.search(17);
     *         skiplist.add(2);
     *         skiplist.erase(3);
     *         skiplist.search(14);
     *         skiplist.add(11);
     *         skiplist.add(0);
     *         skiplist.search(13);
     *         skiplist.add(2);
     *         skiplist.search(1);
     *         skiplist.erase(10);
     *         skiplist.erase(17);
     *         skiplist.search(0);
     *         skiplist.search(5);
     *         skiplist.erase(8);
     *         skiplist.search(9);
     *         skiplist.add(8);
     *         skiplist.erase(11);
     *         skiplist.search(10);
     *         skiplist.erase(11);
     *         skiplist.search(10);
     *         skiplist.erase(9);
     *         skiplist.erase(8);
     *         skiplist.search(15);
     *         skiplist.search(14);
     *         skiplist.add(1);
     *         skiplist.add(6);
     *         skiplist.add(17);
     *         skiplist.add(16);
     *         skiplist.search(13);
     *         skiplist.search(4);
     *         skiplist.search(5);
     *         skiplist.search(4);
     *         skiplist.search(17);
     *         skiplist.search(16);
     *         skiplist.search(7);
     *         skiplist.search(14);
     *         skiplist.search(1);
     */
}
