public class VATCalculatorDemo {
    public static void main(String[] args) {
        TaxCategory[] categories = {
            new Retailer(),
            new Wholesaler(),
            new Importer()
        };

        double[] amounts = {1000.0, 5000.0, 12000.0};

        for (int i = 0; i < categories.length; i++) {
            double vat = categories[i].calculateVAT(amounts[i]);
            System.out.println(categories[i].getClass().getSimpleName()
                    + " VAT on " + amounts[i] + " = " + vat);
        }
    }
}
