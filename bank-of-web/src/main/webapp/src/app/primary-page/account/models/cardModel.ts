
	
export class CardModel {

     number: String;
     expiryDate: String;
     cvc: Number;
     holderName: String;
     accountLinked: String;
     type:String;
     status: String;


	
    constructor( number: String, expiryDate: String, cvc: Number, holderName: String, accountLinked: String,type:String,status:String) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
        this.holderName = holderName;
        this.accountLinked = accountLinked;
                this.type = type;          
                      this.status = status;
    }

    static fromJSONArray(array: Array<Object>): CardModel[] {
        return array["data"].map(obj => new CardModel(obj['cardNo'], obj['expiryDate'], obj['cvc'], obj['holderName'], obj['accountLinked'], obj['type'], obj['status']));
    }
}