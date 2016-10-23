package decrypting;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

public class Test {
	
	long t;
	static long t0=0;
	static long min0=1000000, max0=0;
	static long t1=0;
	static long min1=1000000, max1=0;
	static long t2=0;
	static long min2=1000000, max2=0;
	static long t3=0;
	static long min3=1000000, max3=0;
	
	static String[] chars = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	
	public static void main(String[] args) {
		
		Test test = new Test();
		String text = "11110110 11101001 11110101 11000111 10101101 11101000 01001110 01110111 11010101 00001000 01011101 10001001 01100100 00111010 11100101 01110010 00001111 11111011 11000011 10000111 11100111 10111101 01011000 11001000 01010011 10010111 11010000 00100001 11000100 10110100 10001100 01001011 11110011 10111001 11111001 01010101 10001111 01111011 01011010 01001101 01111011 10001110 11110010 00000101 01101100 11111100 11101000 00111011 11111011 11011111 11101011 11011101 11000001 10101101 11000100 10101110 11000011 00100110 01100000 11010110 01011100 11011111 01101010 01000001 10010111 01111011 11000000 01101111 11001111 00001110 00010100 10001000 00111110 00101001 11010011 11101111 01100111 01111100 11000011 10011111 00001110 01000101 11010010 11010000 00110101 11000000 11000100 10110110 00011100 10100110 10110110 01000001 00011110 01010000 00000100 11010111 00001000";
		text = text.replaceAll(" ", "");
		String key2 = "7e2a7ccd9c14d8247b2dd17718019815712f2b6d76b546a1a891174";
		
		
		//System.out.println(test.decrypt("ade6e7d6623e8104daaccbe72d5116844e5eb346c51d5bf9abe1fcde1d229c81","b30676fd3edc542a410b9dac4473e0ae","W3JyGH2PBbZtFt37LzkK9un1x63oTnfVCF2JZDrlcg/7w4fnvVjIU5fQIcS0jEvzuflVj3taTXuO8gVs/Og7+9/r3cGtxK7DJmDWXN9qQZd7wG/PDhSIPinT72d8w58ORdLQNcDEthymtkEeUATXCA=="));
		//System.out.println(test.decrypt("ade6e7d6623e8104daaccbe72d5116844e5eb346c51d5bf9abe1fcde1d229c81","nFu1UD01ituK2QFBEHErixy2SL1HPse/R+Isthap8mI0OYO6XZS4FFvYqVfLmeuNsSX8jSC2KZQsM7Rq7y24zsdm7xYR+W2SRgstjB9hydPyCgZtboF8UDaTfFNK4qi53zJVlgQgsG7fqj6A3sfjQw=="));

		//System.out.println(Integer.toHexString((int) (Math.pow(16, 7)-1)));
		
		//System.out.println(Integer.parseInt("d000000", 16));
		
		for(int i=0;i<8;i++){
			new worker(i,key2,"0QwJnWZrHFqtLxdke9QtLuX6NjliTDwBTM75Wl7Q4S2a1zrdD72pnHMtSSYuBnrYNU+h12H07rU2lYjbuTm8d2BZ8kw1b4vi//ryMlnfqFJRg8pmyPmZqfwgh3b82iEd4KeVaksW0aG9uB6VwtbqUA==",6,0).start();
		}
		
		
		
		/*
		//ExecutorService exec = Executors.newFixedThreadPool(8);
		for(int i=0;i<(int)Math.pow(16, 5);i++){
			String key1 = Integer.toHexString(i);
			while(key1.length() < 8){
				key1 = "0" + key1;
			}
			if(i % Math.pow(16, 3) == 0){
				System.out.println(key1);
			}
			test.decrypt(key1+key2,"iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp");
			
			//Runnable worker = new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp");
			//exec.execute(new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp"));
					
		}
		//exec.shutdown();
		//while(!exec.isTerminated()){  }
		System.out.println("Finished");*/
		
		/*String key1;
		StringBuilder sb;
		for(int i=0;i<16;i++){
			for(int j=0;j<(int)Math.pow(16, 4);j++){
				long t = System.nanoTime();
				sb = new StringBuilder(Integer.toHexString(j));
				while(sb.length() < 7){
					sb.insert(0, '0');
				}
				sb.insert(0, chars[i]);
				sb.insert(0, chars[0]);
				if(j % Math.pow(16, 5) == 0){
					System.out.println(sb.toString());
				}
				t1 += System.nanoTime() - t;
				t = System.nanoTime();
				test.decrypt(sb.toString()+key2,"0QwJnWZrHFqtLxdke9QtLuX6NjliTDwBTM75Wl7Q4S2a1zrdD72pnHMtSSYuBnrYNU+h12H07rU2lYjbuTm8d2BZ8kw1b4vi//ryMlnfqFJRg8pmyPmZqfwgh3b82iEd4KeVaksW0aG9uB6VwtbqUA==");
				t2 += System.nanoTime() - t;
				
			}
		}
		System.out.println("Part1: " + t1 + "per one: " + t1/Math.pow(16, 5));
		System.out.println("Part1: " + t2 + "per one: " + t2/Math.pow(16, 5));*/
		
	}
	IvParameterSpec iv;
	Cipher cipher;
	Test(){
		byte[] ivec = DatatypeConverter.parseHexBinary("8d5a08adf2e08b5694a1ebb889ddbc9f");
		this.iv = new IvParameterSpec(ivec);
		try {
			this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	
	public String decrypt(String key, String enc){
		 try {
	            SecretKeySpec skeySpec = new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "AES");
	            
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	            //Base64.decodeBase64(enc)
	            byte[] original = cipher.doFinal(Base64.decodeBase64(enc.getBytes("UTF-8")));
	            
	            String res = new String(original);
	            
	            boolean good = true;
	            for(char a:res.toCharArray()){
	            	if(!Character.isLetter(a) && !Character.isDigit(a) && !(a == ' ' || a == '.' || a == '!' || a == '?' || a == '"' || a == ',' || a == '\n')){
	            		good = false;
	            	}
	            }
	            if(good){
	            	System.out.println(res);
	            }
	            return res;
	        } catch (Exception ex) {
	            //nie znaleziono
	        }
		return null;
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

}
