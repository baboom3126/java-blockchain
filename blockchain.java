import java.util.*;

public class blockchain<E>{
  private ArrayList<block> chain = new ArrayList<block>();
  blockchain(){

    this.chain.add(new block( "geni","N/A"));
    // System.out.println(this.chain.get(0).getData());
  }

  public ArrayList<block> getAllChain(){

    return this.chain;

  }

  public boolean addBlock()

}
