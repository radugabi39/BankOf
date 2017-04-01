
export class TransactionTableModel {

    fromAccount: String;
    toAccount: String;
    date: Date;
    description: String;
    transactionStatus: String;
    transactionType: String;
    amount: Number;
    id:Number;

    constructor(fromAccount: String, toAccount: String, date: Date, description: String, transactionStatus: String, transactionType: String, amount: Number,id:Number) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.date = date;
        this.description = description;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.amount = amount;
         this.id = id;
    }
    static fromJSONArray(array: Array<Object>): TransactionTableModel[] {
        return array["data"].map(obj => new TransactionTableModel(obj['fromAccount'], obj['toAccount'], obj['date'], obj['description'], obj['transactionStatus'], obj['transactionType'], obj['amount'], obj['id']));
    }
}