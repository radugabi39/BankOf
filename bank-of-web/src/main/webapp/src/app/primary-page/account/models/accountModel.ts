
	
export class Account {

     number: string;
     currency: string;
     balance: Number;
     type: string;
     overDraft: Boolean;
     status: string;


	
    constructor( number: string, currency: string, balance: Number, type: string, overDraft: Boolean, status: string) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.overDraft = overDraft;
        this.status = status;
    }

    static fromJSONArray(array: Array<Object>): Account[] {
        return array["data"].map(obj => new Account(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status']));
    }
}