
export class SchedulerModel {

  	id:Number;
    toAccount:String;
	fromAccount:String;
	nextPayment:String;
	active:Boolean;
	amount:Number;


	
    constructor( id: Number, toAccount: string, fromAccount: string, nextPayment: Date, active: Boolean,amount:Number) {
        this.id = id;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.nextPayment =  nextPayment.getFullYear()+"-"+(nextPayment.getMonth()+1)+"-"+nextPayment.getDate()+" ";
        this.active = active;
                this.amount = amount;

    }

static fromJSONArray(array: Array<Object>): SchedulerModel[] {
        return array["data"].map(obj => new SchedulerModel(obj['id'], obj['toAccount'], obj['fromAccount'], new Date(obj['nextPayment']), obj['active'], obj['amount']));
    }
}