
	
export class FullAccount {

     accountNo: string;
     currency: string;
     balance: Number;
     type: string;
     overdraft: Boolean;
     status: string;
     limit:Number;

	
    constructor( accountNo: string, currency: string, balance: Number, type: string, overdraft: Boolean, status: string,limit:Number) {
        this.accountNo = accountNo;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.overdraft = overdraft;
        this.status = status;
        this.limit = limit;
    }

    static fromJSONObj(inp: Array<Object>): FullAccount {
        let obj = inp["data"][0];
      return new FullAccount(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status'], obj['limit'])
    }
}