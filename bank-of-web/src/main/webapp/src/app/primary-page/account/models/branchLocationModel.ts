
	
export class BranchLocationModel {

     name: String;
     long:Float64Array;
     lat:Float64Array;


	
    constructor( name: String, long: Float64Array, lat: Float64Array) {
        this.name = name;
        this.long = long;
        this.lat = lat;

    }

    static fromJSONArray(array: Array<Object>): BranchLocationModel[] {
        return array["data"].map(obj => new BranchLocationModel(obj['name'], obj['longitude'], obj['latitude']));
    }
}