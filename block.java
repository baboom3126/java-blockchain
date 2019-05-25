import java.util.Date;
import java.math.BigInteger;
import java.security.MessageDigest;

public class block{

  private static int difficulty = 5;

  private static int blockCounter = 0;
  private int index;
  private String data;
  private String time;
  private String previousHash;
  private String Hash;
  private int nounce=0;
  private boolean isMined = false;


  block(String data,String prevH){
    block.blockCounter += 1;
    index = blockCounter;
    Date date = new Date();
    this.data = data;
    this.time = date.toString();
    this.previousHash = prevH;
    this.Hash = "N/A";
  }

  public int getIndex(){
    return this.index;
  }

  public int getblockCounter(){
    return this.blockCounter;
  }

  public String getData(){
    return this.data;
  }


  public boolean setData(String d){  ////this method is for testing block vaildity
    this.data = d;
    return true;
  }

  public boolean isMined(){
    return this.isMined;
  }

  public void setIsMined(boolean flag){
    this.isMined = flag;
  }

  public String getTime(){
    return this.time;
  }


public boolean setPreviousHash(String prevH){
  this.previousHash = prevH;
  return true;
}

public String getPreviousHash(){
  return this.previousHash;
}

public String getHash(){
  return Hash;
}

public String toString(){
  return "{\n  \"index\":          " + this.index + ",\n  \"Data\":           " +this.data + ",\n  \"Time\":           " + this.time + ",\n  \"PreviousHash\":   " + this.previousHash + ",\n  \"Hash\":           " + this.Hash+",\n  \"IsMined(valid)\": "+this.isMined+"\n}";
}

public String SHA256(){
  String AllBlockData = Integer.toString(index)+data+time+previousHash+Integer.toString(nounce);
  String SHA256HASH = "";
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(AllBlockData.getBytes("utf8"));
        SHA256HASH = String.format("%064x", new BigInteger(1, digest.digest()));
    } catch (Exception e) {
        e.printStackTrace();
    }

  return SHA256HASH;
}



public void blockMining(){
    this.Hash = SHA256();
    String temp = "0";
    String StrDiff = "";
    for(int i = 0 ; i < difficulty ; i++){
      StrDiff = StrDiff+"0";
    }
    System.out.println("-----------------------------\nStart Mining! Block \'"+index+"\' Difficulty \'"+difficulty+"\'");
    while(!temp.equals(StrDiff)){

      this.nounce++;
      this.Hash = SHA256();
      temp = this.Hash.substring(0,difficulty);
      // System.out.println("try \'"+this.Hash+"\'");   //////print hash value of each try
      }

    if(temp.equals(StrDiff)){
    isMined = true;
    System.out.println("Mining successfully!\nTotal(nounce) \'"+nounce+"\' times\n"+"Hash: "+this.Hash+"\n-----------------------------");
    }

}

public boolean isChainValid(){       ////////calculate this.Hash == SHA256()
  boolean flag = false;
  if(this.Hash.equals(SHA256())){
    flag = true;
    System.out.println("Block \'"+this.index+"\' Hash is valid");

  }
  else{
    this.isMined = false;
    System.out.println("Block \'"+this.index+"\' Hash is invalid");

  }
  return flag;
}


}
