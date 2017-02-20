	
export class BalanceModel {

    income:Number;
    outcome:Number;

	constructor(income:Number,outcome:Number) {
        this.income=income;
        this.outcome=outcome;
	}
    static fromJSONObj(array: Array<Object>): BalanceModel {
        return new BalanceModel(array["data"]['income'], array["data"]['outcome']);
    }
}
