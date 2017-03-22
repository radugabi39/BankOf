
	
export class Card {

     number: string;
     expiryDate: string;
     cvc: Number;
     holderName: string;
     accountLinked: string;
     type:String;



	
    constructor( number: string, expiryDate: Date, cvc: Number, holderName: string, accountLinked: string,type:String) {
        this.number = number;
        this.expiryDate = expiryDate.toDateString();
        this.cvc = cvc;
        this.holderName = holderName;
        this.accountLinked = accountLinked;
                this.type = type;
    }

    static fromJSONArray(array: Array<Object>): Card[] {
        return array["data"].map(obj => new Card(obj['accounumberntNo'], obj['expiryDate'], obj['cvc'], obj['holderName'], obj['accountLinked'], obj['type']));
    }
}