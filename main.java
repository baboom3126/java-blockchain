import java.util.*;
import java.util.Scanner;

public class main{
  public static void main(String[] args) {

int currentBlockNumber;
block newblock;
ArrayList<block> blockchain;

Scanner scanner = new Scanner(System.in);
Scanner scanner1 = new Scanner(System.in);

int selection=10;
String scannerData;


 blockchain = new ArrayList<block>();
////////create first block///////////
 block genesisBlock = new block("Genesis Block", "N/A");
 blockchain.add(genesisBlock);
 blockchain.get(0).blockMining();
 System.out.println(blockchain.get(0).toString());
 ////////create first block///////////

System.out.println("[0]Add a block [1]Mining Block [2]Show all blockchain [3]EXIT");
while(selection!=3){
  selection = scanner.nextInt();
  switch(selection){
    case 0:
            System.out.print("Data (store in the block): ");
            scannerData = scanner1.nextLine();
            currentBlockNumber = genesisBlock.getblockCounter();
            newblock = new block(scannerData,blockchain.get(currentBlockNumber-1).getHash());
            blockchain.add(newblock);
            break;
    case 1:
            currentBlockNumber = genesisBlock.getblockCounter();
            blockchain.get(currentBlockNumber-1).blockMining();
            break;
    case 2:
            System.out.println("////////////////Show all blockchain////////////////");
            for(int i = 0 ;i < blockchain.size(); i++){
              System.out.println(blockchain.get(i).toString());
            }
            break;

  }
  System.out.println("[0]Add a block [1]Mining Block [2]Show all blockchain [3]EXIT");

}

// currentBlockNumber = genesisBlock.getblockCounter();
// newblock = new block("Data",blockchain.get(currentBlockNumber-1).getHash());
// blockchain.add(newblock);
// blockchain.get(currentBlockNumber).blockMining();
// System.out.println(blockchain.get(currentBlockNumber).toString());



  }
}
