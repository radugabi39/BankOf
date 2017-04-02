
	
export class TaskModel {

	id:Number;
	  description:String;
	 creationDate:Date;
	 taskStatus:String;
taskType:String;

	
    constructor( id: Number, description: String, creationDate: Date, taskStatus: String, taskType: String) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.taskStatus = taskStatus;
        this.taskType = taskType;

    }

    static fromJSONArray(array: Array<Object>): TaskModel[] {
        return array["data"].map(obj => new TaskModel(obj['id'], obj['description'], obj['creationDate'], obj['taskStatus'], obj['taskType']));
    }
        static fromJSONArrayWS(array: Array<Object>): TaskModel[] {
        return array.map(obj => new TaskModel(obj['id'], obj['description'], obj['creationDate'], obj['taskStatus'], obj['taskType']));
    }
}