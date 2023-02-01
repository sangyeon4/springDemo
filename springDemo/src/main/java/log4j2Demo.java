import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class log4j2Demo {
    public static final Logger logger = LogManager.getLogger(log4j2Demo.class);

    public static void main(String[] args) {
        String[] a = new String[2];
        logger.info("로그를 남기는 테스트입니다.");
        logger.info("포맷팅 테스트{}", 1);
        //인덱스범위 예외 발생시키기..
        try{
            for(int i = 0; i<3; i++){
                System.out.println(a[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            //스택트레이스를 로그로 남겨본다..
            logger.info(e);
        }
        for (int i = 0; i < 10000; i++) {
            logger.info("Rolling file appender example...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
