
	
export class UserModel {

     firstName: string;
     lastName: string;
     phone: string;
     address: string;
     CNP: string;
     email:string;
     city:string;
     country:string;

	
    constructor( firstName: string, lastName: string, phone: string, address: string, CNP: string,email:string, city: string,country:string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.CNP = CNP;
                this.email = email;
                        this.city = city;
                this.country = country;
    }

    static fromJSONObj(inp: Array<Object>): UserModel {
        let obj=inp["data"];
        return new UserModel(obj['firstName'], obj['lastName'], obj['phone'], obj['address'], obj['CNP'], obj['email'], obj['city'], obj['country']);
    }
}