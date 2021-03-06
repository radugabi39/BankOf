
	
export class UserModel {

     firstName: string;
     lastName: string;
     phone: string;
     address: string;
     cnp: string;
     email:string;
     city:string;
     country:string;
     imageURL:string;
	
    constructor( firstName: string, lastName: string, phone: string, address: string, cnp: string,email:string, city: string,country:string,imageURL:string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.cnp = cnp;
                this.email = email;
                        this.city = city;
                this.country = country;
                 this.imageURL = imageURL;
    }

    static fromJSONObj(inp: Array<Object>): UserModel {
        let obj=inp["data"];
        return new UserModel(obj['firstName'], obj['lastName'], obj['phone'], obj['address'], obj['cnp'], obj['email'], obj['city'], obj['country'], obj['imageURL']);
    }
}