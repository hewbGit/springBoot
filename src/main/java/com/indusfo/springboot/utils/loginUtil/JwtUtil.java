package com.indusfo.springboootdemo_user.utils.loginUtil;



/**
 * @ClassName JwtUtil
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/15 12:45
 **/
public class JwtUtil {


    /*final static String base64EncodedSecretKey = "私钥";//私钥

    final static long TOKEN_EXP = 1000 * 60 * 10;//过期时间,测试使用十分钟

    *//*
     *@author arong
     *@description 创建JWT Token
     *@param: claims jwt的所含的用于校验的信息
     *@param: subject 用户唯一标识
     *@param: ttlMillis  过期时间（毫秒）
     *@return java.lang.String
     *@date 2019/1/19
     *//*
    public static String createToken(Map claims,String subject) {
        //指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
            long mills= System.currentTimeMillis();
            Date date = new Date(mills);
        SecretKey secretKey = JwtUtil.generalKey();
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims) //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setIssuedAt(date) //iat: jwt的签发时间
                .setSubject(subject)//一个json格式的字符串作为用户的唯一标志。
                .signWith(signatureAlgorithm, secretKey);//设置签名使用的签名算法和签名使用的秘钥

          if(TOKEN_EXP>=0){
              long expMils= mills+TOKEN_EXP;
              Date exp = new Date(expMils);
              builder.setExpiration(exp);
          }
          return builder.compact();
    }

    *//*
     *@author arong
     *@description
     *@param:  生成secret key
     *@return javax.crypto.SecretKey
     *@date 2019/1/19
     *//*
    private static SecretKey generalKey(){
        //stringKey
        String stringKey = base64EncodedSecretKey;
        // 使用base64解码
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return secretKey;
    }
    *//*
     *@author arong
     *@description 通过jwt解析得到claims数据描述对象
     *@param: jwt
     *@return io.jsonwebtoken.Claims
     *@date 2019/1/19
     *//*
    public static Claims parseJWT(String jwt) throws Exception{
        //得到原来的签名秘钥，用其才能解析JWT
        SecretKey key = generalKey();
        //得到 DefaultJwtParser
        Claims claims = Jwts.parser()
                .setSigningKey(key) //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt

        return claims;
    }
*/
}
