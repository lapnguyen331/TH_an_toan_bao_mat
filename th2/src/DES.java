import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DES {
    private SecretKey key ;
    //genarate secret key
    public SecretKey genKey() throws NoSuchAlgorithmException {
        KeyGenerator gen = KeyGenerator.getInstance("DES");
        return gen.generateKey();
    }
    public void loadKey() throws NoSuchAlgorithmException {
        this.key = genKey();
    }
    public byte[] encrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cip = Cipher.getInstance("DES");

        cip.init(Cipher.ENCRYPT_MODE,key);
        return cip.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }
//    public String encryptBase64(String data){}
//
    public String decrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cip = Cipher.getInstance("DES");

        cip.init(Cipher.DECRYPT_MODE,key);
        return new String(cip.doFinal(data),StandardCharsets.UTF_8);
    }
//    public String decryptBase64(String data)
//
//        //ma hoa file
//    public boolean encryptFile(String srcF, String desF){}
//    public boolean dencryptFile(String srcF, String desF){}

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        DES des = new DES();
        des.loadKey();
        String data = "Nhóm vũ trang Hezbollah thông báo phóng nhiều rocket vào căn cứ đơn vị 7200 chuyên phụ trách hậu cần, bảo dưỡng của quân đội Israel gần thành phố Haifa.\n" +
                "\n" +
                "\"Chúng tôi đã phóng hàng loạt rocket tiên tiến nhằm vào căn cứ của đơn vị 7200 ở phía nam thành phố Haifa, mục tiêu là nhà máy sản xuất chất nổ tại đây\", nhóm vũ trang Hezbollah ở Lebanon cho biết hôm nay.\n" +
                "\n" +
                "Lực lượng Phòng vệ Israel (IDF) chưa bình luận về thông tin. Truyền thông Israel đặt dấu hỏi về tuyên bố của Hezbollah, nói rằng không có còi báo động phòng không và IDF cũng không đưa ra cảnh báo nào trong ngày.";
        System.out.println(Base64.getEncoder().encodeToString(des.key));
        System.out.println(Base64.getEncoder().encodeToString(des.encrypt(data)));
        System.out.println("decrypt res:"+des.decrypt(des.encrypt(data)));
    }
}
