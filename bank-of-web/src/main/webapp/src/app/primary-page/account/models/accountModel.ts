

export class Account {

    number: string;
    currency: string;
    balance: Number;
    type: string;
    overDraft: Boolean;
    status: string;
    limit: Number;
    smsAlert: Boolean



    constructor(number: string, currency: string, balance: Number, type: string, overDraft: Boolean, status: string, limit: Number, smsAlert: Boolean) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.overDraft = overDraft;
        this.status = status;
        this.limit = limit;
        this.smsAlert = smsAlert;
    }

    static fromJSONArray(array: Array<Object>): Account[] {
        return array["data"].map(obj =>
            new Account(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status'], obj['limit'], obj['smsAlert']));
    }

    static fromJSONObj(inp: Array<Object>): Account {
        let obj = inp["data"];
        return new Account(obj['accountNo'], obj['currency'], obj['balance'], obj['type'], obj['overdraft'], obj['status'], obj['limit'], obj['smsAlert']);
    }
}