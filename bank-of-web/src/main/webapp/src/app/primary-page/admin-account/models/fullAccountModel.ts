
	
export class FullAccount {

     accountNo: string;
     currency: string;
     balance: Number;
     type: string;
     overdraft: Boolean;
     status: string;
     limit:Number;
     ownerName:String;
     ownerCNP:String;

	
    constructor( accountNo: string, currency: string, balance: Number, type: string, overdraft: Boolean, status: string,limit:Number,ownerName:String,ownerCNP:String) {
        this.accountNo = accountNo;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.overdraft = overdraft;
        this.status = status;
        this.limit = limit;
        this.ownerName = ownerName;
        this.ownerCNP = ownerCNP;
    }

    static fromJSONObj(inp: Array<Object>): FullAccount {
        let obj = inp["data"][0];
      return new FullAccount(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status'], obj['limit'], obj['ownerName'], obj['ownerCNP'])
    }
}