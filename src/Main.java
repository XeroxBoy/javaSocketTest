import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {
        System.out.println(8 >>2);
        String message = "你好  yiwangzhibujian";
        //首先需要计算得知消息的长度
        try {
            byte[] sendBytes = message.getBytes("UTF-8");
            System.out.println(sendBytes.length >>8);
            System.out.println(sendBytes.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
