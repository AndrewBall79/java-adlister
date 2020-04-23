public class adsDaoFactory {
    private static Ads adsDao;
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new Ads();
        }
        return adsDao;
    }
}
