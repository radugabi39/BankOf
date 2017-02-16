export class Account {
    private name: string;
    private number:Number;
    private currency:string;
    private amount:Number;
    private type:string;



	constructor(name: string,number:Number, currency:string, amount:Number, type:string) {
        this.name=name;
        this.number=number;
        this.currency=currency;
        this.amount=amount;
        this.type=type;
	}
}