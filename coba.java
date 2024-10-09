import java.text.DecimalFormat;

public class coba {
    public static void main(String[] args) {
        long pkp = 196000000L; // PKP dalam rupiah, menggunakan long untuk bilangan bulat besar
        double pph = hitungPPh(pkp);
        DecimalFormat df = new DecimalFormat("###,###.##");
        String formattedPph = df.format(pph);
        
        System.out.println("Total PPh terutang: Rp " + formattedPph);
    }

    public static double hitungPPh(long pkp) {
        double pph = 0;
        if (pkp <= 60000000) {
            pph = pkp * 0.05; // 5% untuk PKP hingga 60 juta
        } else if (pkp <= 250000000) {
            pph = 60000000 * 0.05 + (pkp - 60000000) * 0.15; // 5% untuk 0-60 juta, 15% untuk sisa hingga 250 juta
        } else if (pkp <= 500000000) {
            pph = 60000000 * 0.05 + 190000000 * 0.15 + (pkp - 250000000) * 0.25; // 5% untuk 0-60 juta, 15% untuk 60-250 juta, 25% untuk sisa hingga 500 juta
        } else if (pkp > 500000000 && pkp <= 5000000000L) {
            pph = 60000000 * 0.05 + 190000000 * 0.15 + 250000000 * 0.25 + (pkp - 500000000) * 0.30; // 5% untuk 0-60 juta, 15% untuk 60-250 juta, 25% untuk 250-500 juta, 30% untuk sisa hingga 5 miliar
        } else if (pkp > 5000000000L) {
            pph = 60000000 * 0.05 + 190000000 * 0.15 + 250000000 * 0.25 + 4500000000L * 0.30 + (pkp - 5000000000L) * 0.35; // 5% untuk 0-60 juta, 15% untuk 60-250 juta, 25% untuk 250-500 juta, 30% untuk 500-5 miliar, 35% untuk sisa di atas 5 miliar
        }
        return pph;
    }
}
