import java.math.BigInteger;
import java.security.MessageDigest;
public class sha{
  public static void main(String[] args) {
    String data ="123asdad##12312ssfjeiaw31";
    String toReturn = null;
    	try {
    	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    	    digest.reset();
    	    digest.update(data.getBytes("utf8"));
    	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
          System.out.print(toReturn);
      } catch (Exception e) {
    	    e.printStackTrace();
    	}


}
}
