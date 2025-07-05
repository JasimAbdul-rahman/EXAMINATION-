public class TransactionRecord {
    private String buyerTIN;          
    private String sellerTIN;          
    private double invoiceAmount;      
    private long transactionTimestamp; 
    private String status;             

    public TransactionRecord(String buyerTIN, String sellerTIN, double invoiceAmount, long transactionTimestamp) {
        if (buyerTIN == null || buyerTIN.isEmpty() || sellerTIN == null || sellerTIN.isEmpty()) {
            throw new IllegalArgumentException("Buyer TIN and Seller TIN cannot be empty.");
        }
        if (invoiceAmount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be positive.");
        }
        this.buyerTIN = buyerTIN;
        this.sellerTIN = sellerTIN;
        this.invoiceAmount = invoiceAmount;
        this.transactionTimestamp = transactionTimestamp;
        this.status = "PENDING"; 
    }

    public String getBuyerTIN() {
        return buyerTIN;
    }

    public String getSellerTIN() {
        return sellerTIN;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public long getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        // Validation can be enforced here before modification
        if (invoiceAmount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be positive.");
        }
        this.invoiceAmount = invoiceAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculateVAT(double vatRate) {
        return invoiceAmount * vatRate;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
               "buyerTIN='" + buyerTIN + '\'' +
               ", sellerTIN='" + sellerTIN + '\'' +
               ", invoiceAmount=" + invoiceAmount +
               ", transactionTimestamp=" + transactionTimestamp +
               ", status='" + status + '\'' +
               '}';
    }
}