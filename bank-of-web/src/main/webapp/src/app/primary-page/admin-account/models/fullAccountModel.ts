
	
export class FullAccount {

     number: string;
     currency: string;
     balance: Number;
     type: string;
     overDraft: Boolean;
     status: string;
     limitAmount:Number;

	
    constructor( number: string, currency: string, balance: Number, type: string, overDraft: Boolean, status: string,limitAmount:Number) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.overDraft = overDraft;
        this.status = status;
        this.limitAmount = limitAmount;
    }

    static fromJSONArray(array: Array<Object>): FullAccount[] {
        return array["data"].map(obj => new FullAccount(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status'], obj['limitAmount']));
    }
}