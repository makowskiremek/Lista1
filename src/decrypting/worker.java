package decrypting;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

public class worker extends Thread {

	String enc;
	String ive;
	int begin, end;
	String key;
	//String key1 = "";
	String key2 = "";
	int firsti;
	IvParameterSpec iv;
	Cipher cipher;
	SecretKeySpec skeySpec;
	int start1=0, start2=0;
	
	worker(String key, String ive, String enc){
		this.key = key;
		this.enc = enc;
		this.ive = ive;
	}
	
	worker(int begin, int end, String ive, String enc){
		this.begin = begin;
		this.end = end;
		this.enc = enc;
		this.ive = ive;
	}
	worker(int findex, String key, String enc, int startindex, int startindex2){
		this.firsti = findex;
		this.key2 = key;
		this.enc = enc;
		this.start1 = startindex;
		this.start2 = startindex2;
		
		byte[] ivec = DatatypeConverter.parseHexBinary("cda164f0e62d5f53c0ef69d51d638880");
		this.iv = new IvParameterSpec(ivec);
		try {
			this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	
	String[] chars = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	
	public void betterrun(){
		String key1 = "";
		//StringBuilder keybuilder = new StringBuilder();
		for(int i=start1;i<16;i++){
			for(int j=start2;j<(int)Math.pow(16, 7);j++){
				key1 = Integer.toHexString(j);
				while(key1.length() < 7){
					key1 = "0" + key1;
				}
				key1 = chars[i] + key1;
				key1 = chars[firsti] + key1;
				decrypt(key1+key2,"0QwJnWZrHFqtLxdke9QtLuX6NjliTDwBTM75Wl7Q4S2a1zrdD72pnHMtSSYuBnrYNU+h12H07rU2lYjbuTm8d2BZ8kw1b4vi//ryMlnfqFJRg8pmyPmZqfwgh3b82iEd4KeVaksW0aG9uB6VwtbqUA==");
			}
		}
		firsti += 8;
		for(int i=0;i<16;i++){
			for(int j=0;j<(int)Math.pow(16, 7);j++){
				key1 = Integer.toHexString(j);
				while(key1.length() < 7){
					key1 = "0" + key1;
				}
				key1 = chars[i] + key1;
				key1 = chars[firsti] + key1;
				decrypt(key1+key2,enc);
			}
		}
	}
	
	
	@Override
	public void run(){
		
		//String key1 = "";
		StringBuilder sb;
		for(int i=start1;i<16;i++){
			for(int j=0;j<(int)Math.pow(16, 7);j++){
				sb = new StringBuilder(Integer.toHexString(j));
				while(sb.length() < 7){
					sb.insert(0, '0');
				}
				sb.insert(0, chars[i]);
				sb.insert(0, chars[firsti]);
				if(j % Math.pow(16, 5) == 0){
					System.out.println(sb.toString());
				}
				decrypt(sb.toString()+key2,"0QwJnWZrHFqtLxdke9QtLuX6NjliTDwBTM75Wl7Q4S2a1zrdD72pnHMtSSYuBnrYNU+h12H07rU2lYjbuTm8d2BZ8kw1b4vi//ryMlnfqFJRg8pmyPmZqfwgh3b82iEd4KeVaksW0aG9uB6VwtbqUA==");
			}
		}
		firsti += 8;
		for(int i=0;i<16;i++){
			for(int j=0;j<(int)Math.pow(16, 7);j++){
				sb = new StringBuilder(Integer.toHexString(j));
				while(sb.length() < 7){
					sb.insert(0, '0');
				}
				sb.insert(0, chars[i]);
				sb.insert(0, chars[firsti]);
				if(j % Math.pow(16, 5) == 0){
					System.out.println(sb.toString());
				}
				decrypt(sb.toString()+key2,"0QwJnWZrHFqtLxdke9QtLuX6NjliTDwBTM75Wl7Q4S2a1zrdD72pnHMtSSYuBnrYNU+h12H07rU2lYjbuTm8d2BZ8kw1b4vi//ryMlnfqFJRg8pmyPmZqfwgh3b82iEd4KeVaksW0aG9uB6VwtbqUA==");
			}
		}
		
		
		
		
		/*
		//for(int i=begin;i<=end;i++){
			String key1 = Integer.toHexString(i);
			while(key1.length() < 8){
				key1 = "0" + key1;
			}
			if(i % Math.pow(256, 2) == 0){
				System.out.println(key1);
				long t = System.currentTimeMillis();
			}
			
		for(int i=0;i<(int)Math.pow(16, 8);i++){
			String key1 = Integer.toHexString(i);
			while(key1.length() < 8){
				key1 = "0" + key1;
			}
			key1 = Integer.toString(firsti) + key1;
			if(i % Math.pow(16, 5) == 0){
				System.out.println(key1);
			}
			decrypt(key1+key,"Ui6TcebvYFc5ctA5cVf9jPXl/N/YuAJspsOF1G6SAjPuzep4NWhfBcolbyUUjIDvwkj8zkFVo+goo8EtKwyiZc0tzcg3weVC76sz9Vn+0F9EPVgA74WsPzGAcxtmPCLK63EZZMziZrNROJhf9O1Qxg==");
			
			//Runnable worker = new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp");
			//exec.execute(new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp"));
					
		}
		firsti += 8;
		for(int i=0;i<(int)Math.pow(16, 8);i++){
			String key1 = Integer.toHexString(i);
			while(key1.length() < 8){
				key1 = "0" + key1;
			}
			key1 = Integer.toHexString(firsti) + key1;
			if(i % Math.pow(16, 5) == 0){
				System.out.println(key1);
			}
			decrypt(key1+key2,"Ui6TcebvYFc5ctA5cVf9jPXl/N/YuAJspsOF1G6SAjPuzep4NWhfBcolbyUUjIDvwkj8zkFVo+goo8EtKwyiZc0tzcg3weVC76sz9Vn+0F9EPVgA74WsPzGAcxtmPCLK63EZZMziZrNROJhf9O1Qxg==");
			
			//Runnable worker = new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp");
			//exec.execute(new worker(key1+key2,"b2a9b172733c5353402e5ab526fd39e4","iH+pKCjgg6vXKmxfLw8SBfz1n7YSaVT6BvxTTMvG8RF2Np69hJTr4PvEVvYFWzCp"));
					
		}
		
		
			//String result = decrypt(key,ive,enc);
			if(result != null && isPureAscii(result)){
				System.out.println(result);
				System.out.println("");
				//break;
			}
			
		//}
*/	}

	private String decrypt(String key, String enc) {
		try {
			skeySpec = new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "AES");
            
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            //Base64.decodeBase64(enc)
            byte[] original = cipher.doFinal(Base64.decodeBase64(enc.getBytes("UTF-8")));
            
            String res = new String(original);
            
            boolean good = true;
            for(char a:res.toCharArray()){
            	if(!Character.isLetter(a) && !Character.isDigit(a) && !(a == ' ' || a == '.' || a == '!' || a == '?' || a == '"' || a == ',' || a == '\n' ||  a == ')' ||  a == '(' ||  a == ';' ||  a == ':' || a=='-' || a=='*' || a=='/')){
            		good = false;
            	}
            }
	            if(good){
	            	System.out.println(res);
	            	PrintWriter writer = new PrintWriter("result2.txt", "UTF-8");
	            	writer.println(res);
	            	writer.close();
	            }
	            return res;
	        } catch (Exception ex) {
	           //nie znaleziono
	        }
		return null;
	}
}
