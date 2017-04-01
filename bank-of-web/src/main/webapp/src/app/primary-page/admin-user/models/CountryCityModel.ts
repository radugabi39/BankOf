
	
export class CountryCityModel {

     country: string;
     city:string;

	
    constructor( country: string, city: string) {
        this.country=country;
        this.city=city;
    }

    static fromJSONArray(array: Array<Object>): CountryCityModel[] {
        return array["data"].map(obj => new CountryCityModel(obj['country'], obj['city']));
    }
}