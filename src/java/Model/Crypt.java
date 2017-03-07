/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

    import javax.crypto.Cipher;
    import javax.crypto.spec.IvParameterSpec;
    import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import static org.apache.tomcat.util.codec.binary.Base64.decodeBase64;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64;

 

public class Crypt {
    private String key = "92AE31A79FEEB2A3";
    private String iv = "0123456789ABCDEF";
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
    
    
    private final static String alg = "AES";
    
    private final static String cI = "AES/CBC/PKCS5Padding";
 
    public static String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64((encrypted)));
    }
 
    public static String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
 
}
