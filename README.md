# JniDemo
使用Nkd加密解密
这是一个简单的jni测试
对数据进行加密跟解密

String str = JniUtils.getStringFormC();
String ming = "121212121";
String encrypmi = JniUtils.encode(ming);
String decrypmi = JniUtils.decode(encrypmi);
tv.setText("jni里面String是:"+str+"\n明文:"+ming+"\n加密后:"+encrypmi+"\n解密后:"+decrypmi);
 
主要代码
 /**
     * 加密
     **/
    public static String encode(String msg) {
        String str = "";
        try {
            //用密钥和一组算法参数初始化此 cipher
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            //加密并转换成16进制字符串
            str = asHex(ecipher.doFinal(msg.getBytes()));
        } catch (BadPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (InvalidAlgorithmParameterException e) {
        } catch (IllegalBlockSizeException e) {
        }
        return str;
    }
    
    /**
     * 解密
     **/
    public static String decode(String value) {
        try {
            ecipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            return new String(ecipher.doFinal(asBin(value)));
        } catch (BadPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (InvalidAlgorithmParameterException e) {
        } catch (IllegalBlockSizeException e) {
        }
        return "";
    }
