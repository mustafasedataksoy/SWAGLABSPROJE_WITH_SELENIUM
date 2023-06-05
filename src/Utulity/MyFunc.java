package Utulity;



public class MyFunc {
    public static void bekle(int saniye )
    {
        try {
            Thread.sleep(saniye*1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);// Hata bilgileri burda yazılıyor
        }



    }

}
