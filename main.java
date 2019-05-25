import java.util.*;
import java.util.Scanner;

public class main{
  public static void main(String[] args) {

int currentBlockNumber;
block newblock;
ArrayList<block> blockchain;

Scanner scanner = new Scanner(System.in);
Scanner scanner1 = new Scanner(System.in);
Scanner scanner2 = new Scanner(System.in);

int selection=10;
String scannerData;


 blockchain = new ArrayList<block>();
////////create first block///////////
 block genesisBlock = new block("Genesis Block", "N/A");
 blockchain.add(genesisBlock);
 blockchain.get(0).blockMining();
 System.out.println(blockchain.get(0).toString());
 ////////create first block///////////

System.out.println("[1]Add a block [2]Mining Block [3]Show all blockchain [4]check vaildity [5]Change block Data [0]EXIT");
while(selection!=0){
  selection = scanner.nextInt();
  switch(selection){
    case 1:
            System.out.print("Data (store in the block): ");
            scannerData = scanner1.nextLine();
            currentBlockNumber = genesisBlock.getblockCounter();
            newblock = new block(scannerData,blockchain.get(currentBlockNumber-1).getHash());
            try{
              blockchain.add(newblock);
              System.out.println("Block add successfully!!");
            }
            catch(Exception e){
              System.out.println(e);
            }
            break;
    case 2:
            currentBlockNumber = genesisBlock.getblockCounter();
            boolean ithblcokisMined = false;

            //////check isMined from lastest block
            for(int i = 0 ; i<currentBlockNumber  ; i++  ){
              ithblcokisMined = blockchain.get(i).isMined();
              if(!ithblcokisMined){       ////////if the block not yet mined
                blockchain.get(i).setPreviousHash(blockchain.get(i-1).getHash());
                blockchain.get(i).blockMining();
              }
            }

            ///

            break;
    case 3:
            System.out.println("////////////////Show all blockchain////////////////");
            for(int i = 0 ;i < blockchain.size(); i++){
              System.out.println(blockchain.get(i).toString());
            }
            break;
    case 4:
            boolean flag=false;
            currentBlockNumber = genesisBlock.getblockCounter();
            for(int i = 0 ; i <currentBlockNumber ; i++){
              flag = blockchain.get(i).isChainValid();     ////////check this.Hash == SHA256()

              if(flag == false){
                for(int j = i ; j < genesisBlock.getblockCounter() ; j++)
                {
                  blockchain.get(j).setIsMined(flag);
                }
              }

              if(i != 0){                                  ///////check block i-1 hash == blcok i previousHash
                flag = blockchain.get(i).getPreviousHash().equals(blockchain.get(i-1).getHash());
                if(flag == false){
                  for(int j = i ; j < genesisBlock.getblockCounter() ; j++)
                  {
                    blockchain.get(j).setIsMined(flag);
                  }
                  System.out.println("Block \'"+(i+1)+"\' PreviousHash is not matched with Block \'"+(i)+"\' Hash");

                }
              }
            }
            break;
      case 5:
            System.out.println("which block's data would you like to change?");
            int tempInt = scanner2.nextInt()-1;
            System.out.println("Data:");
            blockchain.get(tempInt).setData(scanner1.nextLine());

            break;
  }
  if(selection!=0){
    System.out.println("-----------------------------------\n[1]Add a block [2]Mining Block [3]Show all blockchain [4]check vaildity [5]Change block Data [0]EXIT");
  }
}

// currentBlockNumber = genesisBlock.getblockCounter();
// newblock = new block("Data",blockchain.get(currentBlockNumber-1).getHash());
// blockchain.add(newblock);
// blockchain.get(currentBlockNumber).blockMining();
// System.out.println(blockchain.get(currentBlockNumber).toString());



  }
}
